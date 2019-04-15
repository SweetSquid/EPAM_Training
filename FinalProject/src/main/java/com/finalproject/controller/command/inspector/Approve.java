package com.finalproject.controller.command.inspector;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.service.ActionReportService;
import com.finalproject.model.dao.service.HistoryService;
import com.finalproject.model.dao.service.TaxReturnService;
import com.finalproject.model.entity.ActionReport;
import com.finalproject.model.entity.TaxReturn;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class Approve implements Command {
    @Override
    @SuppressWarnings("unchecked")
    public String execute(HttpServletRequest request) {
        int taxReturnId = Integer.parseInt((String) request.getAttribute("userTaxReturnId"));
        ActionReportService.create(ActionReport.Action.APPROVED, null, taxReturnId);
        Optional<TaxReturn> taxReturn = TaxReturnService.id(Integer.parseInt(String.valueOf(request.getAttribute("userTaxReturnId"))));
        List<TaxReturn> taxReturnList = (List<TaxReturn>) request.getSession().getAttribute("taxReturnList");
        taxReturn.ifPresent(taxReturnList::remove);
        request.getSession().setAttribute("taxReturnList", taxReturnList);
        taxReturn.ifPresent(p -> HistoryService.create(p.getId(), p.getUserId(),
                ActionReport.Action.APPROVED, null));
        return "redirect:taxreturn/tax-return-list";
    }
}

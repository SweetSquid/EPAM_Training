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

public class Edit implements Command {
    @Override
    @SuppressWarnings("unchecked")
    public String execute(HttpServletRequest request) {
        //noinspection OptionalGetWithoutIsPresent
        request.setAttribute("editAction", TaxReturnService.id(Integer.parseInt(request.getParameter("id"))).get());

        if (request.getParameter("message") != null) {
            int taxReturnId = Integer.parseInt(request.getParameter("id"));
            ActionReport actionReport = ActionReportService.create(ActionReport.Action.EDIT, request.getParameter("message"),taxReturnId);
            List<TaxReturn> taxReturnList = (List<TaxReturn>) request.getSession().getAttribute("taxReturnList");
            Optional<TaxReturn> taxReturn = TaxReturnService.id(Integer.parseInt(String.valueOf(request.getAttribute("userTaxReturnId"))));
            taxReturn.ifPresent(taxReturnList::remove);
            request.getSession().setAttribute("taxReturnList", taxReturnList);
            taxReturn.ifPresent(taxReturn1 -> HistoryService.create(taxReturn1.getId(), taxReturn1.getUserId(),
                    ActionReport.Action.EDIT, actionReport.getMessage()));
            return "redirect:taxreturn/tax-return-list";
        }
        return "/WEB-INF/inspector/edit-report.jsp";
    }
}

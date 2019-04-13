package com.finalproject.controller.command.inspector;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.impl.JDBCActionReportFactory;
import com.finalproject.model.dao.impl.JDBCTaxReturnFactory;
import com.finalproject.model.entity.ActionReport;
import com.finalproject.model.entity.History;
import com.finalproject.model.entity.TaxReturn;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Approve implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        //TODO add to history
        JDBCActionReportFactory dao = DaoFactory.getInstance().createActionReport();
        int taxReturnId = Integer.parseInt((String) request.getAttribute("userTaxReturnId"));
        ActionReport.Action action = ActionReport.Action.APPROVED;
        LocalDateTime date = LocalDateTime.now();
        ActionReport actionReport = new ActionReport();
        actionReport.setAction(action);
        actionReport.setDate(date);
        System.out.println(actionReport.getReport_id() + " " + taxReturnId);
        dao.create(actionReport,taxReturnId);
        List<TaxReturn> taxReturnList = (List<TaxReturn>) request.getSession().getAttribute("taxReturnList");
        JDBCTaxReturnFactory taxReturnDao = DaoFactory.getInstance().createTaxReturn();
        Optional<TaxReturn> taxReturn = taxReturnDao.findById(Integer.parseInt(String.valueOf(request.getAttribute("userTaxReturnId"))));

        if (taxReturn.isPresent()) {
            System.out.println(taxReturn.get().getDate());
            System.out.println(taxReturnList.remove(taxReturn.get()));
        }
        taxReturnList.forEach(p -> System.out.print(p.getId() + " "));
        request.getSession().setAttribute("taxReturnList", taxReturnList);

        History history = new History();
        history.setTaxReturnId(taxReturn.get().getId());
        history.setUserId(taxReturn.get().getUserId());
        history.setAction(ActionReport.Action.APPROVED);
        history.setMessage(actionReport.getMessage());
        history.setDate(LocalDateTime.now());
        DaoFactory.getInstance().createHistory().create(history);

        taxReturnDao.close();
        dao.close();
        return "redirect:taxreturn/tax-return-list";
    }
}

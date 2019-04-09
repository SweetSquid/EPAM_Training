package com.finalproject.controller.command.inspector;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.impl.JDBCActionReportFactory;
import com.finalproject.model.dao.impl.JDBCTaxReturnFactory;
import com.finalproject.model.entity.ActionReport;
import com.finalproject.model.entity.TaxReturn;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Edit implements Command {
    DaoFactory daoFactory = DaoFactory.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        JDBCActionReportFactory dao = daoFactory.createActionReport();

        int taxReturnId = Integer.parseInt((String) request.getAttribute("userTaxReturnId"));

        ActionReport.Action action = ActionReport.Action.EDIT;

        LocalDateTime date = LocalDateTime.now();

        ActionReport actionReport = new ActionReport();
        actionReport.setAction(action);

        actionReport.setDate(date);

        dao.create(actionReport,taxReturnId);

        List<TaxReturn> taxReturnList = (List<TaxReturn>) request.getSession().getAttribute("taxReturnList");

        JDBCTaxReturnFactory taxReturnDao = daoFactory.createTaxReturn();

        Optional<TaxReturn> taxReturn = taxReturnDao.findById(Integer.parseInt(String.valueOf(request.getAttribute("userTaxReturnId"))));

        taxReturn.ifPresent(taxReturnList::remove);

        taxReturnList.forEach(p -> System.out.print(p.getId() + " "));

        request.getSession().setAttribute("taxReturnList",taxReturnList);
        taxReturnDao.close();
        dao.close();

        return "/WEB-INF/inspector/user-tax-return.jsp";
    }
}

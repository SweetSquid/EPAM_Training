package com.finalproject.controller.command.user;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.impl.JDBCActionReportFactory;
import com.finalproject.model.dao.impl.JDBCTaxReturnFactory;
import com.finalproject.model.entity.TaxReturn;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

public class Edit implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int editActionId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("editActionReturnId")));

        if (request.getParameter("taxType") != null ) {
            DaoFactory daoFactory = DaoFactory.getInstance();
            JDBCTaxReturnFactory dao = daoFactory.createTaxReturn();
            TaxReturn taxReturn = dao.getTaxReturnByActionId(editActionId);
            taxReturn.setCategory(TaxReturn.Category.valueOf(request.getParameter("taxType")));
            taxReturn.setDate(LocalDateTime.now());
            dao.update(taxReturn, taxReturn.getId());
            JDBCActionReportFactory actionReportFactory = daoFactory.createActionReport();
            if (dao.taxReturnHasReport(taxReturn.getId())){
                actionReportFactory.delete(editActionId);
            }
            dao.close();
            return "redirect:taxreturn";
        }
        return "/WEB-INF/user/edit-user-tax-return.jsp";
    }
}

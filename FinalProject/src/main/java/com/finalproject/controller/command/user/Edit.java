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
        String taxCategory = request.getParameter("taxCategory");
        String wage = request.getParameter("wage");
        String militaryCollection = request.getParameter("militaryCollection");
        String incomeTax = request.getParameter("incomeTax");
        //TODO add to history table
        if (taxCategory != null && wage != null && militaryCollection != null && incomeTax != null) {
            int editActionId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("editActionReturnId")));
            DaoFactory daoFactory = DaoFactory.getInstance();
            JDBCTaxReturnFactory dao = daoFactory.createTaxReturn();
            TaxReturn taxReturn = dao.getTaxReturnByActionId(editActionId);
            taxReturn.setCategory(taxCategory);
            taxReturn.setDate(LocalDateTime.now());
            taxReturn.setWage(Double.parseDouble(wage));
            taxReturn.setMilitaryCollection(Double.parseDouble(militaryCollection));
            taxReturn.setIncomeTax(Double.parseDouble(incomeTax));
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

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
        //TODO taxreturn/action-report-list/edit?editActionId=27 null
            String taxCategory = request.getParameter("taxCategory");
            String wage = request.getParameter("wage");
            String militaryCollection = request.getParameter("militaryCollection");
            JDBCActionReportFactory actionReportFactory = DaoFactory.getInstance().createActionReport();
            JDBCTaxReturnFactory taxReturnFactory = DaoFactory.getInstance().createTaxReturn();
            request.setAttribute("message", actionReportFactory.readId(Integer.parseInt(String.valueOf(request.getSession()
                    .getAttribute("editActionReturnId")))).getMessage());
            request.setAttribute("taxReturn", taxReturnFactory.getTaxReturnByActionId(Integer.parseInt(String.valueOf(request.getSession().getAttribute("editActionReturnId")))));
            String incomeTax = request.getParameter("incomeTax");
            actionReportFactory.close();
            taxReturnFactory.close();

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
                actionReportFactory = daoFactory.createActionReport();

                if (dao.taxReturnHasReport(taxReturn.getId())) {
                    actionReportFactory.delete(editActionId);
                }
                dao.close();
                actionReportFactory.close();
                request.getSession().setAttribute("editActionReturnId",null);
                return "redirect:taxreturn";
            }
            request.getSession().setAttribute("editActionReturnId",null);
            return "/WEB-INF/user/edit-user-tax-return.jsp";
    }
}

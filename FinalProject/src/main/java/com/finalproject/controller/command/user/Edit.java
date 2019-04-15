package com.finalproject.controller.command.user;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.service.ActionReportService;
import com.finalproject.model.dao.service.TaxReturnService;
import com.finalproject.model.entity.TaxReturn;

import javax.servlet.http.HttpServletRequest;

public class Edit implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        String taxCategory = request.getParameter("taxCategory");
        String wage = request.getParameter("wage");
        String militaryCollection = request.getParameter("militaryCollection");
        String message =  ActionReportService.id(Integer.parseInt(String.valueOf(request.getSession()
                .getAttribute("editActionReturnId")))).getMessage();
        TaxReturn taxReturn = TaxReturnService.getTaxReturnByActionId(Integer.parseInt(String.valueOf(request.getSession().getAttribute("editActionReturnId"))));

        request.setAttribute("taxList", TaxReturn.Category.values());
        request.setAttribute("message", message);
        request.setAttribute("taxReturn", taxReturn);
        String incomeTax = request.getParameter("incomeTax");

        if (taxCategory != null && wage != null && militaryCollection != null && incomeTax != null) {
            int editActionId = Integer.parseInt(String.valueOf(request.getSession().getAttribute("editActionReturnId")));
            taxReturn = TaxReturnService.edit(editActionId, taxCategory, wage, militaryCollection, incomeTax);
            System.out.println(taxReturn);
            if (TaxReturnService.taxReturnHasReport(taxReturn.getId())) {
                ActionReportService.delete(editActionId);
            }
            request.getSession().setAttribute("editActionReturnId", null);
            return "redirect:taxreturn";
        }
        return "/WEB-INF/user/edit-user-tax-return.jsp";
    }
}

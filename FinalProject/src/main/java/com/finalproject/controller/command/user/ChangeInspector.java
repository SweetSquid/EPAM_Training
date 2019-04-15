package com.finalproject.controller.command.user;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.service.ChangeInspectorReportService;
import com.finalproject.model.entity.ChangeInspectorReport;

import javax.servlet.http.HttpServletRequest;

public class ChangeInspector implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        if (request.getSession().getAttribute("inspectorId") != null && request.getParameter("message") != null){
            int userId = (int) request.getSession().getAttribute("userId");
            int prevInspectorId = (Integer) request.getSession().getAttribute("inspectorId");
            String message = request.getParameter("message");

            ChangeInspectorReport.Status status = ChangeInspectorReport.Status.CHANGE;
            ChangeInspectorReportService.create(userId, prevInspectorId, message, status);
            return "redirect:taxreturn/new-tax-return";
        }
        if (request.getSession().getAttribute("inspectorId") == null){
            return "error";
        }
        return "/WEB-INF/user/change-inspector.jsp";
    }
}

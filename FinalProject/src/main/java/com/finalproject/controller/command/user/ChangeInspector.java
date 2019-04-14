package com.finalproject.controller.command.user;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.impl.JDBCChangeInspectorReportFactory;
import com.finalproject.model.entity.ChangeInspectorReport;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

public class ChangeInspector implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println(request.getSession().getAttribute("inspectorId"));
        if (request.getSession().getAttribute("inspectorId") != null && request.getParameter("message") != null){
            JDBCChangeInspectorReportFactory jdbcTaxReturnFactory = DaoFactory.getInstance().createChangeInspectorReport();
            ChangeInspectorReport changeInspectorReport = new ChangeInspectorReport();
            changeInspectorReport.setUserId((Integer) request.getSession().getAttribute("userId"));
            changeInspectorReport.setPreviousInspectorId((Integer) request.getSession().getAttribute("inspectorId"));
            changeInspectorReport.setMessage(request.getParameter("message"));
            changeInspectorReport.setStatus(ChangeInspectorReport.Status.CHANGE);
            changeInspectorReport.setDate(LocalDateTime.now());
            jdbcTaxReturnFactory.create(changeInspectorReport);
            jdbcTaxReturnFactory.close();
            return "redirect:taxreturn/new-tax-return";
        }
        if (request.getSession().getAttribute("inspectorId") == null){
            return "error";
        }
        return "/WEB-INF/user/change-inspector.jsp";
    }
}

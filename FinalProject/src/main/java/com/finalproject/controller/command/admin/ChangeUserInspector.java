package com.finalproject.controller.command.admin;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.impl.JDBCChangeInspectorReportFactory;
import com.finalproject.model.dao.impl.JDBCUserFactory;
import com.finalproject.model.entity.ChangeInspectorReport;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ChangeUserInspector implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        JDBCChangeInspectorReportFactory jdbcChangeInspectorReportFactory= DaoFactory.getInstance().createChangeInspectorReport();
        List<ChangeInspectorReport> changeInspectorList = jdbcChangeInspectorReportFactory.readAll();
        JDBCUserFactory userFactory = DaoFactory.getInstance().createUser();
        List<Integer> inspectorList  = userFactory.getInspectorIdList();
        request.setAttribute("inspectorList", inspectorList);

        if (request.getParameter("id") != null){
            int id = Integer.parseInt(request.getParameter("id"));
            ChangeInspectorReport changeInspectorReport = jdbcChangeInspectorReportFactory.readId(id);
            changeInspectorList.remove(changeInspectorReport);
            changeInspectorReport.setNewInspectorId((Integer) request.getSession().getAttribute("newInspectorId"));
            changeInspectorReport.setMessage("");
            changeInspectorReport.setStatus(ChangeInspectorReport.Status.APPROVED);
            jdbcChangeInspectorReportFactory.update(changeInspectorReport, id);
        }
        request.setAttribute("changeInspectorList", changeInspectorList);
        userFactory.close();
        jdbcChangeInspectorReportFactory.close();
        return "/WEB-INF/admin/change-user-inspector.jsp";
    }
}

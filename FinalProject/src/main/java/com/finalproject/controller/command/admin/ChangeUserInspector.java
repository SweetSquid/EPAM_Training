package com.finalproject.controller.command.admin;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.service.ChangeInspectorReportService;
import com.finalproject.model.dao.service.UserService;
import com.finalproject.model.entity.ChangeInspectorReport;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ChangeUserInspector implements Command {
    //TODO смена инспектора некорректная
    @Override
    public String execute(HttpServletRequest request) {
        List<ChangeInspectorReport> changeInspectorList = ChangeInspectorReportService.readAll();
        List<Integer> inspectorList  = UserService.getInspectorIdList();
        request.setAttribute("inspectorList", inspectorList);

        if (request.getParameter("id") != null){
            int id = Integer.parseInt(request.getParameter("id"));
            ChangeInspectorReport changeInspectorReport = ChangeInspectorReportService.id(id);
            changeInspectorList.remove(changeInspectorReport);
            System.out.println("ChangeUserInspector.java id:"+ request.getSession().getAttribute("newInspectorId"));
            changeInspectorReport.setNewInspectorId((Integer) request.getSession().getAttribute("newInspectorId"));
            changeInspectorReport.setMessage("");
            changeInspectorReport.setStatus(ChangeInspectorReport.Status.APPROVED);
            ChangeInspectorReportService.update(changeInspectorReport, id);
        }
        request.setAttribute("changeInspectorList", changeInspectorList);
        return "/WEB-INF/admin/change-user-inspector.jsp";
    }
}

package com.finalproject.controller.command.user;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.impl.JDBCActionReportFactory;
import com.finalproject.model.entity.ActionReport;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

public class UserActionReport implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int userId = (int) request.getSession().getAttribute("userId");

            JDBCActionReportFactory actionReportFactory = DaoFactory.getInstance().createActionReport();
            List<ActionReport> actionReportList = actionReportFactory.userList(userId);
            System.out.println(Arrays.toString(actionReportList.toArray()));
            request.getSession().setAttribute("userActionReportList", actionReportList);
            actionReportFactory.close();
        return "/WEB-INF/user/user-action-report.jsp";
    }
}

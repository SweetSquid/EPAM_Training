package com.finalproject.controller.command.user;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.impl.JDBCHistoryFactory;
import com.finalproject.model.entity.History;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserHistory implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        JDBCHistoryFactory jdbcHistoryFactory = DaoFactory.getInstance().createHistory();
        List<History> historyList = jdbcHistoryFactory.getByUser((int) request.getSession().getAttribute("userId"));
        request.setAttribute("historyList",historyList);
        jdbcHistoryFactory.close();
        return "/WEB-INF/user/user-history.jsp";
    }
}

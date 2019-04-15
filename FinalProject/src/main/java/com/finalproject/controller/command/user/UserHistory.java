package com.finalproject.controller.command.user;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.service.HistoryService;
import com.finalproject.model.entity.History;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserHistory implements Command {
    //TODO сделать разные таблицы историй по кнопкам (отчёты, смена инспектора и т.д.)
    @Override
    public String execute(HttpServletRequest request) {
        List<History> historyList = HistoryService.getByUser((int) request.getSession().getAttribute("userId"));
        request.setAttribute("historyList",historyList);
        return "/WEB-INF/user/user-history.jsp";
    }
}

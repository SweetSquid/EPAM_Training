package com.finalproject.controller.command;

import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.UserDao;

import javax.servlet.http.HttpServletRequest;

public class Login implements Command {
    public String execute(HttpServletRequest request) {
        //TODO role checker

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && password != null) {
            DaoFactory daoFactory = DaoFactory.getInstance();
            UserDao dao = daoFactory.createUser();
            System.out.println(dao.findByLogin(username));
        }
        return "/login.jsp";
    }
}

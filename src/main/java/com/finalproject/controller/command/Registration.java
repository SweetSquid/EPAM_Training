package com.finalproject.controller.command;

import javax.servlet.http.HttpServletRequest;

public class Registration implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(username + " " + email + " " + password);
        return "redirect:registration.jsp";
    }
}

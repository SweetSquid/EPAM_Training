package com.finalproject.controller.command;

import javax.servlet.http.HttpServletRequest;

public class Login implements Command {
    public String execute(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + " " + password);
        if( username == null || username.equals("") || password == null || password.equals("")  ){
            return "redirect:login.jsp";
        }
        return "redirect:login.jsp";
    }
}

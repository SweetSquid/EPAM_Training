package com.finalproject.controller.command;

import javax.servlet.http.HttpServletRequest;

public class Logout implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().setAttribute("role", null);
        return "redirect:taxreturn";
    }
}

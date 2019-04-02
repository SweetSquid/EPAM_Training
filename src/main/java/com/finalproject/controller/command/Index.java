package com.finalproject.controller.command;

import javax.servlet.http.HttpServletRequest;

public class Index implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "redirect:index.jsp";
    }
}

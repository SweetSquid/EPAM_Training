package com.finalproject.controller.command.inspector;

import com.finalproject.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class Edit implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/inspector/user-tax-return.jsp";
    }
}

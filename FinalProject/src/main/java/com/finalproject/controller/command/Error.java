package com.finalproject.controller.command;

import javax.servlet.http.HttpServletRequest;

public class Error implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/404.html";
    }
}

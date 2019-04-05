package com.finalproject.controller;


import com.finalproject.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String role = (String) request.getSession().getAttribute("role");
        String path = request.getRequestURI();
        System.out.println(path);
        path = path.replaceAll(".*/taxreturn/", "");

        String defaultPath;

        commands = (Map<String, Command>) request.getSession().getAttribute("commands");


        System.out.println(path);
        Command command = commands.getOrDefault(path,
                (r) -> "error");
        String page = command.execute(request);
        System.out.println(page + " page cont: " + request.getSession().getAttribute("commands") + " Role: " + role);

        if (page.contains("redirect")) {
            response.sendRedirect(page.replace("redirect:", "/"));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }
        request.getSession().getAttribute("role");
    }
}

package com.finalproject.controller;


import com.finalproject.controller.command.Command;
import com.finalproject.model.entity.TaxReturn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();
    private HashSet<String> loggedUsers = new HashSet<>();

    public void init() {
        getServletContext().setAttribute("loggedUsers", loggedUsers);
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
        request.setAttribute("taxList", TaxReturn.Category.values());
        String path = request.getRequestURI();
        String logout = (String) request.getSession().getAttribute("logout");

        if (logout != null && logout.equals("false")) {
            loggedUsers.add((String) request.getSession().getAttribute("loggedUser"));
        }

        request.setAttribute("userTaxReturnId",request.getParameter("id"));


        path = path.replaceAll(".*/taxreturn/", "");
        commands = (Map<String, Command>) request.getSession().getAttribute("commands");
        Command command = commands.getOrDefault(path,
        (r) -> "redirect:error");
        String page = command.execute(request);



        if (page.contains("redirect")) {
            response.sendRedirect(page.replace("redirect:", "/"));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }

    }
}

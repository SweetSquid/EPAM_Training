package com.finalproject.controller;


import com.finalproject.controller.command.Command;
import com.finalproject.controller.command.Index;
import com.finalproject.controller.command.Login;
import com.finalproject.controller.command.Registration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    public void init(){
        commands.put("login", new Login());
        commands.put("registration", new Registration());
        commands.put("index", new Index());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     processRequest(request,response);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        System.out.println(path);
        path = path.replaceAll(".*/app/" , "");
        System.out.println(path);
        Command command = commands.getOrDefault(path ,
                (r)->"/index.jsp");
        String page = command.execute(request);
        if(page.contains("redirect")){
            response.sendRedirect(page.replace("redirect:", "/"));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}

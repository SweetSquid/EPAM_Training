package com.finalproject.controller.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionDestroyed(HttpSessionEvent session) {
        HashSet<String> loggedUsers = (HashSet<String>) session.getSession()
                .getServletContext().getAttribute("loggedUsers");
        String login = (String) session.getSession().getAttribute("login");
        loggedUsers.remove(login);
        session.getSession().getServletContext().setAttribute("loggedUsers", loggedUsers);
    }
}

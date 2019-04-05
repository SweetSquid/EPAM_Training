package com.finalproject.controller.command;

import com.finalproject.model.dao.service.UserService;
import com.finalproject.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Login implements Command {
    private Map<String, String> users = new HashMap<>();

    public Login() {
        users.put("login", "index.jsp");
        users.put("ADMIN", "redirect:taxreturn");
        users.put("INSPECTOR", "redirect:taxreturn");
        users.put("USER", "redirect:taxreturn");
    }

    public String execute(HttpServletRequest request) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null || password == null ||
                username.equals("") || password.equals("")) {
            return "/login.jsp";
        }

        Optional<User> user = new UserService().login(username);
        if (user.isPresent() && password.equals(user.get().getPassword())) {
            request.getSession().setAttribute("role", user.get().getRole().toString());
            request.getSession().setAttribute("user_name", user.get().getName());
            return users.getOrDefault(user.get().getRole().toString(), users.get("login"));
        }
        return "/login.jsp";
    }
}

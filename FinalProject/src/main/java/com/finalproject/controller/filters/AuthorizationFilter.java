
package com.finalproject.controller.filters;

import com.finalproject.controller.command.Command;
import com.finalproject.controller.command.Error;
import com.finalproject.controller.command.Login;
import com.finalproject.controller.command.Logout;
import com.finalproject.controller.command.Registration;
import com.finalproject.controller.command.admin.Home;
import com.finalproject.model.entity.enums.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AuthorizationFilter implements Filter {
    private Map<String, Command> user = new HashMap<>();
    private Map<String, Command> admin = new HashMap<>();
    private Map<String, Command> inspector = new HashMap<>();
    private Map<String, Command> guest = new HashMap<>();

    //TODO сделать мапу дейсвтий для каждого юзера отдельно
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        admin.put("/taxreturn", new Home());
        admin.put("logout", new Logout());
        admin.put("error", new Error());
        user.put("/taxreturn", new com.finalproject.controller.command.user.Home());
        user.put("logout", new Logout());
        user.put("error", new Error());
        guest.put("login", new Login());
        guest.put("registration", new Registration());
        guest.put("/taxreturn", new com.finalproject.controller.command.Home());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String role = (String) request.getSession().getAttribute("role");
        if (role != null && role.equals(Role.ADMIN.toString())) {
            request.getSession().setAttribute("commands", admin);
        }
        if (role != null && role.equals(Role.USER.toString())) {
            request.getSession().setAttribute("commands", user);
        }
        if (role != null && role.equals(Role.INSPECTOR.toString())) {
            request.getSession().setAttribute("commands", inspector);
        }
        if (role == null) {
            request.getSession().setAttribute("commands", guest);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
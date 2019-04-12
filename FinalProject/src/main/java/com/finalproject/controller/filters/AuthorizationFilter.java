
package com.finalproject.controller.filters;

import com.finalproject.controller.command.Command;
import com.finalproject.controller.command.Logout;
import com.finalproject.controller.command.guest.Login;
import com.finalproject.controller.command.guest.Registration;
import com.finalproject.controller.command.inspector.Approve;
import com.finalproject.controller.command.inspector.Edit;
import com.finalproject.controller.command.inspector.TaxReturnData;
import com.finalproject.model.entity.User.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AuthorizationFilter implements Filter {
    private Map<String, Command> commands = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String role = (String) request.getSession().getAttribute("role");
        commands.clear();
        //TODO guest == null
        if (role == null) {
            commands.put("login", new Login());
            commands.put("registration", new Registration());
            commands.put("/taxreturn", new com.finalproject.controller.command.guest.Home());
        }
        if (role != null && role.equals(Role.ADMIN.toString())) {
            commands.put("/taxreturn", new com.finalproject.controller.command.admin.Home());
            commands.put("logged_users", new com.finalproject.controller.command.admin.LoggedUsers());
            commands.put("logout", new Logout());
        }
        if (role != null && role.equals(Role.USER.toString())) {
            commands.put("/taxreturn", new com.finalproject.controller.command.user.Home());
            commands.put("new-tax-return", new com.finalproject.controller.command.user.NewTaxReturn());
            commands.put("action-report-list", new com.finalproject.controller.command.user.UserActionReport());
            commands.put("action-report-list/edit", new com.finalproject.controller.command.user.Edit());
            commands.put("logout", new Logout());
        }
        if (role != null && role.equals(Role.INSPECTOR.toString())) {
            commands.put("logout", new Logout());
            commands.put("approve", new Approve());
            commands.put("tax-return-list", new TaxReturnData());
            commands.put("edit", new Edit());
            commands.put("/taxreturn", new com.finalproject.controller.command.inspector.Home());
        }

        request.getSession().setAttribute("commands", commands);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
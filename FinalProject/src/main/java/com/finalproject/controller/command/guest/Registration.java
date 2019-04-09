package com.finalproject.controller.command.guest;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.UserDao;
import com.finalproject.model.entity.User;
import com.finalproject.model.entity.enums.Role;

import javax.servlet.http.HttpServletRequest;

public class Registration implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (name != null && username != null
                && email != null && password != null) {
            DaoFactory daoFactory = DaoFactory.getInstance();
            UserDao dao = daoFactory.createUser();
            User user = new User();
            user.setRole(Role.USER);
            user.setName("name");
            user.setUsername("username");
            user.setEmail("email@gmail.com");
            user.setPassword("password");
            user.setRole(Role.USER);
            user.setName(request.getParameter("name"));
            user.setUsername(request.getParameter("username"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            dao.create(user);
            dao.close();
            new Login().execute(request);
            return "redirect:taxreturn";
        }
        return "/registration.jsp";
    }
}



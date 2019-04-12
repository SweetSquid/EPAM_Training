package com.finalproject.controller.command.guest;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.impl.JDBCUserFactory;
import com.finalproject.model.entity.User;
import com.finalproject.model.entity.User.Role;
import com.finalproject.model.exception.NotUniqueEmailException;
import com.finalproject.model.exception.NotUniqueIdCodeException;
import com.finalproject.model.exception.NotUniquePhoneException;
import com.finalproject.model.exception.NotUniqueUsernameException;

import javax.servlet.http.HttpServletRequest;

public class Registration implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String fullName = request.getParameter("fullName");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String idCode = request.getParameter("idCode");
        String phone = request.getParameter("phone");

        if (fullName != null && username != null
                && email != null && password != null
                && idCode != null && phone != null) {
            DaoFactory daoFactory = DaoFactory.getInstance();
            JDBCUserFactory dao = daoFactory.createUser();
            User user = new User();
            user.setRole(Role.USER);
            user.setFullname(fullName);
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setPhone(phone);
            user.setIdCode(idCode);
            try {
                dao.create(user);
            } catch (NotUniqueUsernameException | NotUniquePhoneException | NotUniqueEmailException | NotUniqueIdCodeException e){
                request.setAttribute("notUnique", e.getMessage());
                return "/registration.jsp";
            }
            dao.close();
            new Login().execute(request);
            return "redirect:taxreturn";
        }

        return "/registration.jsp";
    }
}



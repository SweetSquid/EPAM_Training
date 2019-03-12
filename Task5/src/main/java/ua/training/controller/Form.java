package ua.training.controller;

import ua.training.model.entity.Notebook;
import ua.training.model.entity.WrongEmailException;
import ua.training.model.entity.WrongLoginException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static ua.training.controller.RegexContainer.*;

@WebServlet(urlPatterns = "/Form", loadOnStartup = 0)
public class Form extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        boolean checkExc = true;
        response.setContentType("text/html;charset=utf-8");

        String firstName = request.getParameter("firstName");
        String login = request.getParameter("login");
        String email = request.getParameter("email");

        request.setAttribute("firstName", firstName);
        request.setAttribute("login", login);
        request.setAttribute("email", email);


        String errorMsg = "Wrong ";
        if (!validateInput(firstName, NAME_LAT_REGEX)) {
            errorMsg = concatStrings(errorMsg + "name(min length: 3)");
        }
        if (!validateInput(login, LOGIN_REGEX)) {
            errorMsg = concatStrings(errorMsg + "login(min length: 3)");
        }
        if (!validateInput(email, EMAIL_REGEX)) {
            errorMsg = concatStrings(errorMsg + "email");
        }

        try {
            new Notebook(firstName, login, email);
        } catch (WrongEmailException | WrongLoginException e) {
            checkExc = false;
            e.printStackTrace();
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>" + e.getMessage() + "</font><br>");
            rd.include(request, response);
        }

        if (!errorMsg.equals("Wrong ") && checkExc) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>" + errorMsg + "</font><br>");
            rd.include(request, response);
        }
        if (errorMsg.equals("Wrong ") && checkExc){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/success.jsp");
            rd.include(request, response);
        }



}

    private boolean validateInput(String message, String regex) {
        return message.matches(regex);
    }

    private String concatStrings(String... message) {
        StringBuilder concat = new StringBuilder();
        for (String s : message) {
            concat.append(s);
            concat.append(" ");
        }
        return concat.toString();
    }

}
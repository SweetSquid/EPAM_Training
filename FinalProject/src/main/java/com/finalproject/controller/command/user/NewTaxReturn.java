package com.finalproject.controller.command.user;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.TaxReturnDao;
import com.finalproject.model.dao.UserDao;
import com.finalproject.model.entity.TaxReturn;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class NewTaxReturn implements Command {
    //TODO сделать так, чтобы был только один инспектор tax.setInspectorId()
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("userid: " + request.getSession().getAttribute("userId"));
        System.out.println("taxType: " + request.getParameter("taxType"));

        if (request.getParameter("taxType") != null && request.getSession().getAttribute("userId") != null ) {
            DaoFactory daoFactory = DaoFactory.getInstance();
            TaxReturnDao dao = daoFactory.createTaxReturn();
            UserDao userDao = daoFactory.createUser();

            TaxReturn taxReturn = new TaxReturn();
            taxReturn.setUserId((Integer) request.getSession().getAttribute("userId"));
            taxReturn.setInspectorId(getRandomElement(userDao.getInspectorIdList()));
            taxReturn.setCategory(TaxReturn.Category.valueOf(request.getParameter("taxType")));
            taxReturn.setDate(LocalDateTime.now());

            dao.create(taxReturn);
            dao.close();
            return "redirect:taxreturn";
        }

        return "/WEB-INF/user/new-tax-return.jsp";
    }

    private int getRandomElement(List<Integer> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}

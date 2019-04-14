package com.finalproject.controller.command.user;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.UserDao;
import com.finalproject.model.dao.impl.JDBCTaxReturnFactory;
import com.finalproject.model.dao.service.UserService;
import com.finalproject.model.entity.TaxReturn;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NewTaxReturn implements Command {
    //TODO сделать так, чтобы был только один инспектор tax.setInspectorId()
    @Override
    public String execute(HttpServletRequest request) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        if (request.getParameter("taxCategory") != null && userId != null ) {
            DaoFactory daoFactory = DaoFactory.getInstance();
            JDBCTaxReturnFactory dao = daoFactory.createTaxReturn();
            UserDao userDao = daoFactory.createUser();

            TaxReturn taxReturn = new TaxReturn();
            taxReturn.setUserId(userId);
            if (!UserService.userHasInspector(userId)) {
                System.out.println(Arrays.toString(userDao.getInspectorIdList().toArray()));
                taxReturn.setInspectorId(getRandomElement(userDao.getInspectorIdList()));
            }else{
                taxReturn.setInspectorId( dao.getInspectorId(userId));
            }
            taxReturn.setCategory(request.getParameter("taxCategory"));
            taxReturn.setDate(LocalDateTime.now());
            taxReturn.setWage(Double.parseDouble(request.getParameter("wage")));
            taxReturn.setMilitaryCollection(Double.parseDouble(request.getParameter("militaryCollection")));
            taxReturn.setIncomeTax(Double.parseDouble(request.getParameter("incomeTax")));
            request.getSession().setAttribute("inspectorId",taxReturn.getInspectorId());
            dao.create(taxReturn);
            userDao.close();
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

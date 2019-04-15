package com.finalproject.controller.command.inspector;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.impl.JDBCTaxReturnFactory;
import com.finalproject.model.dao.service.TaxReturnService;
import com.finalproject.model.entity.TaxReturn;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TaxReturnData implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int inspectorId = (int) request.getSession().getAttribute("userId");
        if (request.getSession().getAttribute("taxReturnList") == null) {
            request.getSession().setAttribute("taxReturnList", TaxReturnService.inspectorList(inspectorId));
            //TODO у меня хранятся данные через сессию, сделать как-то на всех
        }
        return "/WEB-INF/inspector/user-tax-return.jsp";
    }
}

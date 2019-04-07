package com.finalproject.controller.command.inspector;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.impl.JDBCTaxReturnFactory;
import com.finalproject.model.entity.TaxReturn;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TaxReturnData implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int inspectorId = (int) request.getSession().getAttribute("userId");
        //TODO добавить изменения списка отчётов, когда пользователь добавляет отчёт
        if (request.getSession().getAttribute("taxReturnList") == null) {
            JDBCTaxReturnFactory dao = DaoFactory.getInstance().createTaxReturn();
            List<TaxReturn> taxReturnList = dao.getInspectorTaxReturn(inspectorId);
            request.getSession().setAttribute("taxReturnList", taxReturnList);
        }
        //TODO добавить логин пользователя в отчёт
        return "/WEB-INF/inspector/user-tax-return.jsp";
    }
}
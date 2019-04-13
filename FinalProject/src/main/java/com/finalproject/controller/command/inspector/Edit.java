package com.finalproject.controller.command.inspector;

import com.finalproject.controller.command.Command;
import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.impl.JDBCActionReportFactory;
import com.finalproject.model.dao.impl.JDBCHistoryFactory;
import com.finalproject.model.dao.impl.JDBCTaxReturnFactory;
import com.finalproject.model.entity.ActionReport;
import com.finalproject.model.entity.History;
import com.finalproject.model.entity.TaxReturn;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Edit implements Command {
    DaoFactory daoFactory = DaoFactory.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        JDBCTaxReturnFactory jdbcTaxReturnFactory = DaoFactory.getInstance().createTaxReturn();
        TaxReturn taxReturn1 = jdbcTaxReturnFactory.findById(Integer.parseInt(request.getParameter("id"))).get();
        jdbcTaxReturnFactory.close();
        request.setAttribute("editAction",taxReturn1);
        if (request.getParameter("message") != null) {
            JDBCActionReportFactory dao = daoFactory.createActionReport();
            int taxReturnId = Integer.parseInt(request.getParameter("id"));
            ActionReport.Action action = ActionReport.Action.EDIT;
            LocalDateTime date = LocalDateTime.now();
            ActionReport actionReport = new ActionReport();
            actionReport.setAction(action);
            actionReport.setDate(date);
            actionReport.setMessage(request.getParameter("message"));
            dao.create(actionReport, taxReturnId);
            List<TaxReturn> taxReturnList = (List<TaxReturn>) request.getSession().getAttribute("taxReturnList");
            JDBCTaxReturnFactory taxReturnDao = daoFactory.createTaxReturn();
            Optional<TaxReturn> taxReturn = taxReturnDao.findById(Integer.parseInt(String.valueOf(request.getAttribute("userTaxReturnId"))));
            taxReturn.ifPresent(taxReturnList::remove);
            taxReturnList.forEach(p -> System.out.print(p.getId() + " "));
            request.getSession().setAttribute("taxReturnList", taxReturnList);
            taxReturnDao.close();

            History history = new History();
            history.setTaxReturnId(taxReturn.get().getId());
            history.setUserId(taxReturn.get().getUserId());
            history.setAction(ActionReport.Action.EDIT);
            history.setMessage(actionReport.getMessage());
            history.setDate(LocalDateTime.now());
            JDBCHistoryFactory jdbcHistoryFactory = DaoFactory.getInstance().createHistory();
            jdbcHistoryFactory.create(history);

            jdbcHistoryFactory.close();
            dao.close();
            return "redirect:taxreturn/tax-return-list";
        }
        return "/WEB-INF/inspector/edit-report.jsp";
    }
}

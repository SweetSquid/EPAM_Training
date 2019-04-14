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

public class Approve implements Command {
    @Override
    @SuppressWarnings("unchecked")
    public String execute(HttpServletRequest request) {
        //TODO add to history
        JDBCActionReportFactory dao = DaoFactory.getInstance().createActionReport();
        int taxReturnId = Integer.parseInt((String) request.getAttribute("userTaxReturnId"));
        ActionReport.Action action = ActionReport.Action.APPROVED;
        LocalDateTime date = LocalDateTime.now();
        ActionReport actionReport = new ActionReport();
        actionReport.setAction(action);
        actionReport.setDate(date);
        actionReport.setTaxReturnId(taxReturnId);
        dao.create(actionReport);
        List<TaxReturn> taxReturnList = (List<TaxReturn>) request.getSession().getAttribute("taxReturnList");
        JDBCTaxReturnFactory taxReturnDao = DaoFactory.getInstance().createTaxReturn();
        Optional<TaxReturn> taxReturn = taxReturnDao.findById(Integer.parseInt(String.valueOf(request.getAttribute("userTaxReturnId"))));
        taxReturn.ifPresent(taxReturnList::remove);
        request.getSession().setAttribute("taxReturnList", taxReturnList);
        if (taxReturn.isPresent()) {
            History history = new History();
            history.setTaxReturnId(taxReturn.get().getId());
            history.setUserId(taxReturn.get().getUserId());
            history.setAction(ActionReport.Action.APPROVED);
            history.setMessage(actionReport.getMessage());
            history.setDate(LocalDateTime.now());
            JDBCHistoryFactory historyDao = DaoFactory.getInstance().createHistory();
            historyDao.create(history);
            historyDao.close();
        }
        taxReturnDao.close();
        dao.close();
        return "redirect:taxreturn/tax-return-list";
    }
}

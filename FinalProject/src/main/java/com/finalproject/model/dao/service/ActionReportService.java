package com.finalproject.model.dao.service;

import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.impl.JDBCActionReportFactory;
import com.finalproject.model.entity.ActionReport;

import java.time.LocalDateTime;
import java.util.List;

public class ActionReportService {
    private static DaoFactory daoFactory = DaoFactory.getInstance();

    public static ActionReport create(ActionReport.Action action, String message, int taxId){
        try (JDBCActionReportFactory dao = daoFactory.createActionReport()){
            ActionReport actionReport = new ActionReport();
            actionReport.setAction(action);
            actionReport.setDate(LocalDateTime.now());
            actionReport.setTaxReturnId(taxId);
            actionReport.setMessage(message);
            dao.create(actionReport);
            return actionReport;
        }
    }

    public static boolean delete(int id){
        try (JDBCActionReportFactory dao = daoFactory.createActionReport()){
            return dao.delete(id);
        }
    }

    public static ActionReport id(int id){
        try (JDBCActionReportFactory dao = daoFactory.createActionReport()){
            return dao.readId(id);
        }
    }

    public static List<ActionReport> userList(int userId){
        try (JDBCActionReportFactory dao = DaoFactory.getInstance().createActionReport()){
            return dao.userList(userId);
        }
    }
}

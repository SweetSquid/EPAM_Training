package com.finalproject.model.dao.service;

import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.impl.JDBCHistoryFactory;
import com.finalproject.model.entity.ActionReport;
import com.finalproject.model.entity.History;

import java.time.LocalDateTime;
import java.util.List;

public class HistoryService {
    private static DaoFactory daoFactory = DaoFactory.getInstance();

    public static boolean create(int taxId, int userId, ActionReport.Action action, String message) {
        try (JDBCHistoryFactory historyDao = daoFactory.createHistory()) {
            History history = new History();
            history.setTaxReturnId(taxId);
            history.setUserId(userId);
            history.setAction(action);
            history.setDate(LocalDateTime.now());
            history.setMessage(message);
            historyDao.create(history);
        }
        return false;
    }

    public static List<History> getByUser(int userId){
        try (JDBCHistoryFactory dao = DaoFactory.getInstance().createHistory()){
            return dao.getByUser(userId);
        }
    }
}

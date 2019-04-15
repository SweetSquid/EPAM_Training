package com.finalproject.model.dao.service;

import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.impl.JDBCChangeInspectorReportFactory;
import com.finalproject.model.entity.ChangeInspectorReport;

import java.time.LocalDateTime;
import java.util.List;

public class ChangeInspectorReportService {
    private static DaoFactory daoFactory = DaoFactory.getInstance();

    public static List<ChangeInspectorReport> readAll() {
        try (JDBCChangeInspectorReportFactory dao = daoFactory.createChangeInspectorReport()) {
            return dao.readAll();
        }
    }

    public static ChangeInspectorReport id(int id) {
        try (JDBCChangeInspectorReportFactory dao = daoFactory.createChangeInspectorReport()) {
            return dao.readId(id);
        }
    }

    public static boolean update(ChangeInspectorReport entity, int id) {
        try (JDBCChangeInspectorReportFactory dao = daoFactory.createChangeInspectorReport()) {
            return dao.update(entity, id);
        }
    }

    public static boolean create(int userId, int prevInspId, String message, ChangeInspectorReport.Status status) {
        try (JDBCChangeInspectorReportFactory dao = daoFactory.createChangeInspectorReport()) {
            ChangeInspectorReport changeInspectorReport = new ChangeInspectorReport();
            changeInspectorReport.setUserId(userId);
            changeInspectorReport.setPreviousInspectorId(prevInspId);
            changeInspectorReport.setMessage(message);
            changeInspectorReport.setStatus(status);
            changeInspectorReport.setDate(LocalDateTime.now());
            return dao.create(changeInspectorReport);
        }
    }
}

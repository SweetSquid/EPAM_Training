package com.finalproject.model.dao;

import com.finalproject.model.entity.ActionReport;

import java.util.List;
import java.util.Optional;

public interface ActionReportDao{
    // TODO добавить расширение интерфейса GenericDao
    Optional<ActionReport> findById(int id);
    boolean create(ActionReport entity, int taxReturnId);
    ActionReport readId(int id);

    List<ActionReport> readAll();
    List<ActionReport> userList(int userId);
    boolean update(ActionReport actionReport, int id);

    boolean delete(int id);

    void close();
}

package com.finalproject.model.dao;

import com.finalproject.model.entity.ActionReport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ActionReportDao extends AutoCloseable {

    boolean create(ActionReport entity, int taxReturnId);

    ActionReport extractFromResultSet(ResultSet rs) throws SQLException;

    ActionReport readId(int id);

    List<ActionReport> readAll();

    boolean update(ActionReport actionReport, int id);

    boolean delete(int id);

    List<ActionReport> userList(int userId);

    void close();
}

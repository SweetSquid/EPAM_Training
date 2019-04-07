package com.finalproject.model.dao.impl;

import com.finalproject.model.dao.ActionReportDao;
import com.finalproject.model.dao.mapper.ActionReportMapper;
import com.finalproject.model.entity.ActionReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCActionReportFactory implements ActionReportDao {
    private Connection connection;

    public JDBCActionReportFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<ActionReport> findById(int id) {
        Optional<ActionReport> result = Optional.empty();

        String query = "SELECT * FROM action_report WHERE username = ?";

        try (PreparedStatement ps = connection.prepareCall(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ActionReportMapper actionReportMapper = new ActionReportMapper();

            if (rs.next()) {
                result = Optional.of(actionReportMapper.extractFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public boolean create(ActionReport actionReport, int taxReturnId) {
        boolean result = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ActionReportSQL.CREATE_ACTION_REPORT.QUERY);
            preparedStatement.setString(1, actionReport.getAction().toString());
            preparedStatement.setString(2, actionReport.getMessage());
            preparedStatement.setObject(3, actionReport.getDate());
            result = preparedStatement.execute();
            // TODO сделать создание tax_return_has_return_id
//            PreparedStatement ps = connection.prepareCall(ActionReportSQL.GET_ACTION_REPORT.QUERY);
//            ps.setInt(1, taxReturnId);
//            ResultSet rs = ps.executeQuery();
//            ActionReportMapper actionReportMapper = new ActionReportMapper();
//            ActionReport actionReport1 = actionReportMapper.extractFromResultSet(rs);
//
//            preparedStatement = connection.prepareStatement(ActionReportSQL.CREATE_LINK.QUERY);
//            preparedStatement.setInt(1, taxReturnId);
//            preparedStatement.setInt(2, actionReport1.getReport_id());
//            result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ActionReport readId(int id) {
        return null;
    }

    @Override
    public List<ActionReport> readAll() {
        return null;
    }

    @Override
    public List<ActionReport> userList(int userId) {
        List<ActionReport> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareCall(ActionReportSQL.READ_ACTION_REPORT_LIST_BY_USER.QUERY)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            ActionReportMapper actionReportMapper = new ActionReportMapper();

            while (rs.next()) {
                result.add(actionReportMapper.extractFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(ActionReport actionReport, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public void close() {

    }

    enum ActionReportSQL {
        CREATE_ACTION_REPORT("INSERT INTO action_report (report_id, action, message, date) VALUES (DEFAULT, (?), (?), (?))"),
        READ_ACTION_REPORT_LIST_BY_USER("SELECT a.report_id, a.action, a.message, a.date\n"+
                                                "FROM action_report a\n"+
                                                "       left join tax_return_has_action_report b ON a.report_id = b.action_report_report_id\n"+
                                                "       left join tax_return c on c.tax_return_id = b.tax_return_tax_return_id\n"+
                                                "WHERE c.user_id = (?)\n");
        String QUERY;

        ActionReportSQL(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}

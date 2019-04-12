package com.finalproject.model.dao.impl;

import com.finalproject.model.dao.HistoryDao;
import com.finalproject.model.entity.ActionReport.Action;
import com.finalproject.model.entity.History;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class JDBCHistoryFactory implements HistoryDao {
    private Connection connection;

    JDBCHistoryFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(History history) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(JDBCHistorySQL.CREATE.QUERY);
            preparedStatement.setInt(1, history.getTaxReturnId());
            preparedStatement.setInt(2, history.getReport_id());
            preparedStatement.setInt(3, history.getUserId());
            preparedStatement.setString(4, history.getAction().toString());
            preparedStatement.setString(5,history.getMessage());
            preparedStatement.setObject(6,history.getDate());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public History extractFromResultSet(ResultSet rs) throws SQLException {
        History history = new History();
        history.setTaxReturnId(rs.getInt("tax_return_id"));
        history.setReport_id(rs.getInt("report_id"));
        history.setUserId(rs.getInt("user_id"));
        history.setAction(Action.valueOf(rs.getString("action")));
        history.setMessage(rs.getString("message"));
        history.setDate(rs.getDate("date").toLocalDate().atStartOfDay(ZoneOffset.UTC).toLocalDateTime());
        return history;
    }

    @Override
    public History readId(int id) {
        History result = new History();
        try (PreparedStatement ps = connection.prepareCall(JDBCHistorySQL.READ_ALL.QUERY)) {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = extractFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<History> readAll() {
        List<History> result = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareCall(JDBCHistorySQL.READ_ALL.QUERY)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(History history, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<History> getByUser(int userId) {
        return null;
    }

    enum JDBCHistorySQL{
        READ("SELECT a.tax_return_id, a.report_id, b.user_id, a.action, a.message, a.date\n" +
                "FROM action_report a\n" +
                "       LEFT JOIN tax_return b ON a.tax_return_id = b.tax_return_id" +
                "WHERE history_id = ?;"),
        CREATE("INSERT INTO history (tax_return_id, report_id, user_id, action, message, date) VALUES (?, ?, ?, ?, ?, ?)"),
        READ_ALL("SELECT * FROM history");

        String QUERY;

        JDBCHistorySQL(String QUERY){
            this.QUERY = QUERY;
        }
    }
}

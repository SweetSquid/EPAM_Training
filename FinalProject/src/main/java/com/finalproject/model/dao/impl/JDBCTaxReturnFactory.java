package com.finalproject.model.dao.impl;

import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.TaxReturnDao;
import com.finalproject.model.dao.mapper.TaxReturnMapper;
import com.finalproject.model.entity.TaxReturn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCTaxReturnFactory implements TaxReturnDao {

    private Connection connection;

    public JDBCTaxReturnFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean changeInspector(int inspectorId, int userId) {
        try (PreparedStatement ps = connection.prepareCall(TaxReturnSQL.CHANGE_INSPECTOR.QUERY)) {
            ps.setInt(1, inspectorId);
            ps.setInt(2, userId);
            return ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<TaxReturn> getUserTaxReturn(int userId) {
        List<TaxReturn> taxReturnList = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareCall(TaxReturnSQL.GET_ALL_USER_TAXRETURN.QUERY)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            TaxReturnMapper taxReturnMapper = new TaxReturnMapper();

            while (rs.next()) {
                taxReturnList.add(taxReturnMapper.extractFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taxReturnList;
    }

    @Override
    public List<TaxReturn> getInspectorTaxReturn(int inspectorId) {
        List<TaxReturn> taxReturnList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareCall(TaxReturnSQL.GET_ALL_INSPECTOR_TAXRETURN.QUERY)) {
            ps.setInt(1, inspectorId);
            ResultSet rs = ps.executeQuery();
            TaxReturnMapper taxReturnMapper = new TaxReturnMapper();

            while (rs.next()) {
                taxReturnList.add(taxReturnMapper.extractFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taxReturnList;
    }


    @Override
    public Optional<TaxReturn> findById(int taxReturnId) {
        Optional<TaxReturn> taxReturn = Optional.empty();

        String query = "SELECT * FROM tax_return WHERE tax_return_id = ?";
        try (PreparedStatement ps = connection.prepareCall(query)) {
            ps.setInt(1, taxReturnId);
            ResultSet rs = ps.executeQuery();
            TaxReturnMapper taxReturnMapper = new TaxReturnMapper();
            //TODO если надо выводить пару значений, поменять if на while
            if (rs.next()) {
                taxReturn = Optional.of(taxReturnMapper.extractFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taxReturn;
    }

    @Override
    public boolean create(TaxReturn taxReturn) {
        JDBCUserFactory dao = DaoFactory.getInstance().createUser();
        boolean result = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(TaxReturnSQL.CREATE.QUERY);
            preparedStatement.setInt(1, taxReturn.getUserId());
            preparedStatement.setInt(2, taxReturn.getInspectorId());
            preparedStatement.setString(3, taxReturn.getCategory().toString());
            preparedStatement.setObject(4, taxReturn.getDate());
            result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public TaxReturn readId(int id) {
        return null;
    }

    @Override
    public List<TaxReturn> readAll() {

        return null;
    }

    @Override
    public boolean update(TaxReturn taxReturn, int taxReturnId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(TaxReturnSQL.UPDATE.QUERY);
            preparedStatement.setString(1, taxReturn.getCategory().toString());
            preparedStatement.setObject(2, taxReturn.getDate());
            preparedStatement.setInt(3, taxReturnId);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    enum TaxReturnSQL {
        READ("SELECT login, name FROM users WHERE login = (?)"),
        DELETE("DELETE FROM users WHERE login = (?)"),
        CREATE("INSERT INTO tax_return (tax_return_id, user_id, inspector_id, category_id, date) VALUES (DEFAULT, (?), (?), (?), (?))"),
        UPDATE("UPDATE tax_return SET category_id = (?), date = (?) WHERE tax_return_id= (?)"),
        CHANGE_INSPECTOR("UPDATE tax_return SET inspector_id = (?) WHERE user_id = (?)"),
        GET_ALL_USER_TAXRETURN("SELECT * FROM tax_return WHERE user_id = (?)"),
        GET_ALL_INSPECTOR_TAXRETURN("SELECT * FROM tax_return WHERE inspector_id =(?)");

        String QUERY;

        TaxReturnSQL(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}

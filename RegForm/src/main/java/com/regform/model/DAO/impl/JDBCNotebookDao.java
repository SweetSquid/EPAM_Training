package com.regform.model.DAO.impl;

import com.regform.model.DAO.NotebookDao;
import com.regform.model.DAO.mapper.NotebookMapper;
import com.regform.model.entity.Notebook;
import com.regform.model.entity.WrongLoginException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCNotebookDao implements NotebookDao {
    private Connection connection;

    public JDBCNotebookDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Notebook> getAll() {
        List<Notebook> result = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(NotebookSQL.GET_ALL.QUERY);
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                String name = rs.getString("name");
                String login = rs.getString("login");
                result.add(new Notebook(name, login));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean create(Notebook notebook) throws WrongLoginException {
        NotebookMapper notebookMapper = new NotebookMapper();
        if (!notebookMapper.isUnique(notebook)){
            throw new WrongLoginException("It's not unique, please input another login");
        }

        boolean result = false;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(NotebookSQL.ADD.QUERY);
            preparedStatement.setString(1, notebook.getLogin());
            preparedStatement.setString(2, notebook.getNameNotebook());
            result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Notebook read(String log) {

        String login = null;
        String name = null;
        try {
            PreparedStatement statement = connection.prepareStatement(NotebookSQL.READ.QUERY);
            statement.setString(1, log);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                name = rs.getString("name");
                login = rs.getString("login");
            }
            return new Notebook(name, login);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean update(Notebook model, String log) {
        String login = model.getLogin();
        String name = model.getNameNotebook();
        try {
            PreparedStatement statement = connection.prepareStatement(NotebookSQL.UPDATE.QUERY);
            statement.setString(1, login);
            statement.setString(2, name);
            statement.setString(3, log);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public boolean delete(String login) {
        try {
            PreparedStatement statement = connection.prepareStatement(NotebookSQL.DELETE.QUERY);
            statement.setString(1, login);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

    enum NotebookSQL {
        READ("SELECT login, name FROM users WHERE login = (?)"),
        DELETE("DELETE FROM users WHERE login = (?)"),
        ADD("INSERT INTO users (id, login, name) VALUES (DEFAULT, (?), (?))"),
        UPDATE("UPDATE users SET login = (?), name = (?) WHERE login = (?)"),
        GET_ALL("SELECT name, login FROM users");

        String QUERY;

        NotebookSQL(String QUERY) {
            this.QUERY = QUERY;
        }
    }


}

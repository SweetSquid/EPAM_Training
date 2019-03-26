package com.regform.model.DAO.impl;

import com.regform.model.DAO.DaoFactory;
import com.regform.model.DAO.NotebookDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public NotebookDao createNoteDAO() {
        return new JDBCNotebookDao(getConnection());
    }


    public Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}

package com.finalproject.model.dao.impl;

import com.finalproject.model.dao.DaoFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class JDBCDaoFactory extends DaoFactory {
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();
    final static Logger LOGGER = Logger.getLogger(JDBCDaoFactory.class.getSimpleName());


    public Connection getConnection() {
        try {
            LOGGER.info("connection good");
            return dataSource.getConnection();
        } catch (SQLException e) {
            LOGGER.info("connection bad");
            throw new RuntimeException(e);
        }
    }

    @Override
    public JDBCUserFactory createUser() {
        return new JDBCUserFactory(getConnection());
    }

    @Override
    public JDBCTaxReturnFactory createTaxReturn() {
        LOGGER.info("createTaxReturn");
        return new JDBCTaxReturnFactory(getConnection());
    }

    @Override
    public JDBCActionReportFactory createActionReport() {
        return new JDBCActionReportFactory(getConnection());
    }
}

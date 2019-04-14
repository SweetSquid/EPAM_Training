package com.finalproject.model.dao.impl;

import com.finalproject.model.dao.DaoFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class JDBCDaoFactory extends DaoFactory {
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();
    private final static Logger LOGGER = Logger.getLogger(JDBCDaoFactory.class.getSimpleName());

    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
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

    @Override
    public JDBCHistoryFactory createHistory() {
        return new JDBCHistoryFactory(getConnection());
    }

    @Override
    public JDBCChangeInspectorReportFactory createChangeInspectorReport() {
        return new JDBCChangeInspectorReportFactory(getConnection());
    }
}

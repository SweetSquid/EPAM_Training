package com.finalproject.model.dao;


import com.finalproject.model.dao.impl.JDBCActionReportFactory;
import com.finalproject.model.dao.impl.JDBCDaoFactory;
import com.finalproject.model.dao.impl.JDBCTaxReturnFactory;
import com.finalproject.model.dao.impl.JDBCUserFactory;

public abstract class DaoFactory{

    private static DaoFactory daoFactory;
    public static DaoFactory getInstance() {

        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new JDBCDaoFactory();
                }
            }
        }

        return daoFactory;
    }

    public abstract JDBCUserFactory createUser();
    public abstract JDBCTaxReturnFactory createTaxReturn();
    public abstract JDBCActionReportFactory createActionReport();
}

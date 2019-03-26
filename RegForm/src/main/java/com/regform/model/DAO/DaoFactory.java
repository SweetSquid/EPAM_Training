package com.regform.model.DAO;


import com.regform.model.DAO.impl.JDBCDaoFactory;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract NotebookDao createNoteDAO();

    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    daoFactory = new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }

}

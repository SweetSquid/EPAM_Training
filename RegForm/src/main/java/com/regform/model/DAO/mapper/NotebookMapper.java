package com.regform.model.DAO.mapper;

import com.regform.model.DAO.impl.JDBCDaoFactory;
import com.regform.model.DAO.impl.JDBCNotebookDao;
import com.regform.model.entity.Notebook;

import java.util.List;

import java.sql.Connection;

import static com.regform.model.DAO.DaoFactory.getInstance;

public class NotebookMapper implements ObjectMapper<Notebook> {

    @Override
    public boolean isUnique(Notebook notebook) {

        JDBCDaoFactory jdbcDaoFactory = (JDBCDaoFactory) getInstance();
        Connection connection = jdbcDaoFactory.getConnection();
        JDBCNotebookDao jdbcNotebookDao = new JDBCNotebookDao(connection);
        List<Notebook> notebookList = jdbcNotebookDao.getAll();

        for (Notebook notebook1 : notebookList) {
            if (notebook1.getLogin().equals(notebook.getLogin())) {
                return false;
            }
        }
        return true;
    }
}

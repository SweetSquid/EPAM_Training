package com.regform.controller;

import com.regform.model.DAO.impl.JDBCDaoFactory;
import com.regform.model.DAO.impl.JDBCNotebookDao;
import com.regform.model.entity.Notebook;
import com.regform.model.entity.WrongLoginException;
import com.regform.view.View;

import java.sql.Connection;
import java.util.Scanner;

import static com.regform.model.DAO.DaoFactory.getInstance;

public class Controller {
    private View view;
    private Scanner sc = new Scanner(System.in);
    private JDBCDaoFactory jdbcDaoFactory = (JDBCDaoFactory) getInstance();
    private Connection connection = jdbcDaoFactory.getConnection();
    private JDBCNotebookDao jdbcNotebookDao = new JDBCNotebookDao(connection);


    public Controller(View view) {
        this.view = view;
    }

    public void process() {
        InputNotebook inputNotebook = new InputNotebook(view, sc);
        inputNotebook.inputNote();
        getNotebook(inputNotebook);
    }

    private void getNotebook(InputNotebook inputNotebook) {
        while (true) {
            try {
                jdbcNotebookDao.create(new Notebook(inputNotebook.getFirstName(),
                        inputNotebook.getLoginData()));
                break;
            } catch (WrongLoginException e) {
                e.printStackTrace();
                inputNotebook.inputLogin();
            }
        }
    }
}
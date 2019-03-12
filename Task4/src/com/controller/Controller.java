package com.controller;

import com.model.Model;
import com.model.entity.Notebook;
import com.model.entity.WrongLoginException;
import com.view.View;

import java.util.Scanner;

import static com.view.MessageConstants.*;

public class Controller {
    private Model model;
    private View view;
    private Scanner sc = new Scanner(System.in);


    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void process() {
        InputNotebook inputNotebook = new InputNotebook(view,sc);
        inputNotebook.inputNote();

        Notebook notebook = getNotebook(inputNotebook);
        model.addNotebook(notebook);
        model.getNotebook();
    }

    private Notebook getNotebook(InputNotebook inputNotebook) {
        Notebook notebook = null;
        while(true) {
            try {
                notebook = new Notebook (inputNotebook.getFirstName(),
                        inputNotebook.getLoginData());
                break;
            } catch (WrongLoginException e) {
                e.printStackTrace();
                inputNotebook.inputLogin();
            }
        }
        return notebook;
    }
}
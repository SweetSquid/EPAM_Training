package com.controller;

import com.model.Model;
import com.view.View;

import java.util.Scanner;

import static com.view.MessageConstants.*;
import static com.controller.RegexContainer.*;

public class Controller {
    private Model model;
    private View view;
    private Scanner sc = new Scanner(System.in);

    /**
     * Created by Mykyta Frolov
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void process() {
        UtilityController utilityController =
                new UtilityController(sc, view);

        String firstN = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? NAME_UKR_REGEX : NAME_LAT_REGEX;
        String secondN = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? SECOND_NAME_UKR_REGEX : SECOND_NAME_LAT_REGEX;

        String firstName = utilityController.inputStringValueWithScanner(FIRST_NAME_MESSAGE, firstN);
        String secondName = utilityController.inputStringValueWithScanner(SECOND_NAME_MESSAGE, secondN);
        String username = utilityController.inputStringValueWithScanner(USERNAME_MESSAGE, USERNAME_REGEX);
        String email = utilityController.inputStringValueWithScanner(EMAIL_MESSAGE, EMAIL_REGEX);
        String phone = utilityController.inputStringValueWithScanner(PHONE_MESSAGE, PHONE_NUMBER_REGEX);

        model.addToNotebook(secondName);
        model.addToNotebook(firstName);
        model.addToNotebook(secondName + " " + firstName.charAt(0) + ".");
        model.addToNotebook(username);
        model.addToNotebook(phone);
        model.addToNotebook(email);
    }
}
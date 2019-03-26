package com.regform.controller;

import com.regform.view.View;

import java.util.Scanner;

import static com.regform.controller.RegexContainer.LOGIN_REGEX;
import static com.regform.controller.RegexContainer.NAME_LAT_REGEX;
import static com.regform.controller.RegexContainer.NAME_UKR_REGEX;
import static com.regform.view.MessageConstants.*;

public class InputNotebook {
    private View view;
    private Scanner sc;

    private String firstName;
    private String loginData;

    public InputNotebook(View view, Scanner sc) {
        this.view = view;
        this.sc = sc;
    }

    public void inputNote() {
        UtilityController utilityController = new UtilityController(sc, view);
        String str = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? NAME_UKR_REGEX : NAME_LAT_REGEX;

        this.firstName = utilityController.
                inputStringValueWithScanner(FIRST_NAME_MESSAGE, str);
        this.loginData = utilityController.
                inputStringValueWithScanner(LOGIN_MESSAGE, LOGIN_REGEX);
    }

    public void inputLogin(){
        UtilityController utilityController =
                new UtilityController(sc, view);
        this.loginData =
                utilityController.inputStringValueWithScanner
                        (LOGIN_MESSAGE, LOGIN_REGEX);
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLoginData() {
        return loginData;
    }
}

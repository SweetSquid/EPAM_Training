package com.controller;

import com.view.View;

import java.util.Scanner;

public class UtilityController {
    private Scanner scanner;
    private View view;

    UtilityController(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }

    /**
     * Check input data
     * @param message data that's checked
     * @param regex regex for data
     * @return data if it's correct
     */
    String inputStringValueWithScanner(String message, String regex){
        String res;
        view.printStringInput(message);
        while( !(scanner.hasNext() &&
                (res = scanner.next()).matches(regex))) {
            view.printWrongInput(message);
        }
        return res;
    }
}

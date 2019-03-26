package com.regform.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Mykyta Frolov
 */
public class View implements MessageConstants{
    private static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    new Locale("ua","UA"));

    public static void printMessage(String message){
        System.out.println(message);
    }


    private void printConcatStrings(String... message){
        StringBuilder concat = new StringBuilder();
        for (String s : message) {
            concat.append(s);
            concat.append(" ");
        }
        System.out.println(concat.toString());
    }

    public void printWrongInput(String message) {
        printConcatStrings(
                bundle.getString(WRONG_INPUT_MESSAGE),
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(message));
    }

    public void printStringInput(String message) {
        printConcatStrings(
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(message));
    }
}

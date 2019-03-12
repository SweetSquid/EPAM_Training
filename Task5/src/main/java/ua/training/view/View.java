package ua.training.view;

import java.util.Locale;
import java.util.ResourceBundle;


public class View implements MessageConstants{
    private static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    new Locale("en","UA"));
}

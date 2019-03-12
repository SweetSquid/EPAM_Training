package project.view;

import java.util.Locale;
import java.util.ResourceBundle;


public class View implements MessageConstants{
    private static String MESSAGES_BUNDLE_NAME = "messages";
    //Sets user language
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    new Locale("ua","UA"));
}

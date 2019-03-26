package com.regform;

import com.regform.controller.Controller;
import com.regform.view.View;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new View());
        controller.process();
    }
}

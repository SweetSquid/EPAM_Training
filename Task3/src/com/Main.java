package com;

import com.controller.Controller;
import com.model.Model;
import com.view.View;

/**
 * Created by Mykyta Frolov
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new Model(), new View());
        controller.process();
    }
}

package controller;

import model.Actions;
import view.View;

public class Controller {
    private Actions actions;
    private View view;

    public Controller(Actions actions, View view){
        this.actions = actions;
        this.view = view;
    }

    public void process() throws IllegalArgumentException {
        view.printMessage("After refactoring: ");
        view.printMessage(Actions.actions.get(0).add(6,4).toString());
        view.printMessage(Actions.actions.get(0).subtract(6,4).toString());
        view.printMessage(Actions.actions.get(0).multiply(6,4).toString());
        view.printMessage(Actions.actions.get(0).divide(6,4).toString());
        view.printMessage(Actions.actions.get(0).add("6","4").toString());
    }

}

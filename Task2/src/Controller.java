import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Mykyta Frolov
 */
public class Controller {
    private Model model;
    private View view;
    private Scanner sc = new Scanner(System.in);
    private int attempts = 0;
    private int inputNum;
    private int minValue;
    private int maxValue;

    Controller(Model model, View view) {
        this.view = view;
        this.model = model;
        this.minValue = model.getMinValue();
        this.maxValue = model.getMaxValue();
    }

    public void process() {
        model.setGuess(rand(minValue, maxValue));
        view.printMessage("" + model.getGuess());
        guessNum();
    }

    /**
     * Sets randomly number from range
     * @param min minimum range value
     * @param max maximum range value
     * @return random number
     */
    private int rand(int min, int max) {
        Random rand = new Random();
        return (int) rand.nextInt((max - min) + 1) + min;
    }

    /**
     * Check input data
     * @param sc object of Scanner
     * @return true if it's int
     * @return false if it's not int
     */
    private boolean checkNum(Scanner sc) {
        try {
            inputNum = sc.nextInt();
        } catch (InputMismatchException exception) {
            return false;
        }
        return true;
    }

    /**
     * Help user to guess faster
     * @param inputNum input number
     */
    private void closeGuess(int inputNum) {
        if (Math.abs(inputNum - model.getGuess()) <= 10) {
            view.printMessage(view.CLOSE_NUMBER_MESSAGE);
            view.printMessage(view.RANGE_MESSAGE + getRange());
        }
        if (Math.abs(inputNum - model.getGuess()) >= 60) {
            view.printMessage(view.WRONG_NUMBER_MESSAGE);
            view.printMessage(view.RANGE_MESSAGE + getRange());
        }
        if (Math.abs(inputNum - model.getGuess()) < 60 && Math.abs(inputNum - model.getGuess()) > 10) {
            view.printMessage(view.WRONG_TRY_MESSAGE + getRange());
        }
        model.addAttempt(inputNum);
    }

    /**
     * Get all attempts
     */
    private void getStats(){
        int index = 1;
        view.printMessage(view.ATTEMPTS_MESSAGE + attempts);
        for (Integer attempt : model.getAllAttempts()) {
            System.out.println("Attempt " + index + ", number " + attempt);
            index++;
        }
    }

    /**
     * Get current range
     */
    private String getRange() {
        return "[" + minValue + "," + maxValue + "]";
    }

    private void outOfRange(int inputNum) {
        if (inputNum < 0 || inputNum > 100) {
            view.printMessage(view.BEYOND_THE_RANGE_MESSAGE);
        }
    }

    /**
     * Asks the user for a number in the range until he/she win, changes range depending on input
     */
    private void guessNum() {
        view.printMessage(view.START_MESSAGE);
        while (true) {
            while (checkNum(sc) && inputNum != model.getGuess()) {
                attempts++;
                if (inputNum == maxValue || inputNum == minValue) {
                    if (inputNum == maxValue) {
                        maxValue--;
                        closeGuess(inputNum);
                    }
                    if (inputNum == minValue) {
                        minValue++;
                        closeGuess(inputNum);
                    }
                } else {
                    if (inputNum > model.getGuess() && inputNum <= maxValue) {
                        maxValue = inputNum;
                        closeGuess(inputNum);
                    }
                    if (inputNum < model.getGuess() && inputNum >= minValue) {
                        minValue = inputNum;
                        closeGuess(inputNum);
                    }
                    if (inputNum > maxValue || inputNum < minValue) {
                        view.printMessage(view.BEYOND_THE_RANGE_MESSAGE);
                    }
                }
                while (!sc.hasNextInt()) {
                    view.printMessage(view.ERROR_TYPE_MESSAGE);
                    sc.next();
                }
            }
            outOfRange(inputNum);
            if (inputNum == model.getGuess()) {
                model.addAttempt(inputNum);
                attempts++;
                view.printMessage(view.CONGRATULATION_MESSAGE);
                getStats();
                break;
            }
        }
    }
}


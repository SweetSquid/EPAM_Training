import java.util.Scanner;

/**
 * Created by Mykyta Frolov
 */
public class Controller {
    private View view;
    private Model model;

    Controller(View view, Model model){
        this.model = model;
        this.view = view;
    }

    public void process(){
        Scanner sc = new Scanner(System.in);
        this.model.addToString(checkString(sc,"Hello"));
        this.model.addToString(checkString(sc,"world"));
        view.printMessage(view.RESULT_MESSAGE+model.toString());
    }

    /**
     * validates input data
     * @param sc scanner data
     * @param checkable checkable string data
     * @return value
     */
    private String checkString(Scanner sc, String checkable){
        view.printMessage(view.INPUT_MESSAGE);
        String value = sc.next();
        while (!value.equals(checkable)) {
            view.printMessage(view.ERROR_MESSAGE);
            value = sc.next();
        }
        view.printMessage(view.CORRECT_MESSAGE);
        return value;
    }

}

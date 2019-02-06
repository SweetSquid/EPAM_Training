import java.util.Scanner;


/**
 * Created by Mykyta Frolov
 */
public class Main {
    public static void main(String[] args) {
        // Initialization
        Scanner in = new Scanner(System.in);
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view,model);
        // Run
        controller.process();
    }
}

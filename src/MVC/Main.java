package MVC;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Entry point of the program
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 11.06.2016)
 */
public class Main {
    public static void main(String[] args) {
        // Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.processUser();
    }
}

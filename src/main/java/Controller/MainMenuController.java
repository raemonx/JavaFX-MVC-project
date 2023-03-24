/***
 * ............................................................
 *    Project Phase 1 , SOEN 6441
 *    ©(Faraaz, Himangshu, Shivesh)
 *    Written by:
 *                @author Himangshu Shekhar Baruah , Student ID 40229774
 *                @author Ahmad Faraaz Jafri, Student ID 40232742
 *                @author Shivesh Chaudhary, Student ID 40228107
 * ............................................................
 */
package Controller;

import View.AddPropertyMenuView;
import View.MainMenuView;
import javafx.stage.Stage;

public class MainMenuController {
    private final MainMenuView view;

//    Main main = new Main();

    public MainMenuController(MainMenuView view) {
        this.view = view;
    }

    public void start(Stage primaryStage) throws Exception {
        System.out.println("-------- Welcome to Rental Management System --------");
        int selection = -1;

        view.start(primaryStage, result -> {
            // Do something with the result

            if (result==1){
                System.out.println(result);
                AddPropertyMenuController addPropertyMenuController = new AddPropertyMenuController(new AddPropertyMenuView());
                addPropertyMenuController.start(primaryStage);
            }
        });
    }
}

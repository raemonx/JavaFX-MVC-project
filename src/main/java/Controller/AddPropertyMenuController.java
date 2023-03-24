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
import View.CreatePropertyView;
import View.MainMenuView;
import javafx.stage.Stage;

public class AddPropertyMenuController {

    private final AddPropertyMenuView view;

    public AddPropertyMenuController(AddPropertyMenuView view) {
        this.view = view;
    }

    public void start(Stage primaryStage) throws Exception {
        view.start(primaryStage, result -> {
            if (result == 1) {
                CreatePropertyController controller = new CreatePropertyController(new CreatePropertyView());
                controller.createProperty(primaryStage, 1);
            } else if (result == 2) {
                CreatePropertyController controller = new CreatePropertyController(new CreatePropertyView());
                controller.createProperty(primaryStage, 2);
            } else if (result == 3) {
                CreatePropertyController controller = new CreatePropertyController(new CreatePropertyView());
                controller.createProperty(primaryStage, 3);
            } else if (result == 4) {
                MainMenuController controller = new MainMenuController(new MainMenuView());
                controller.start(primaryStage);
            }

        });
    }
}


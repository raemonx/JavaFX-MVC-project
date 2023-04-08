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

import Model.Property;
import View.PropertiesAvailableOrUnavailableView;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.util.List;

public class PropertiesAvailableOrUnavailableController {
    private final PropertiesAvailableOrUnavailableView view;

    public PropertiesAvailableOrUnavailableController(PropertiesAvailableOrUnavailableView view) {
        this.view = view;
    }

    public void displayProperties(Stage primaryStage, List<Property> properties, boolean availableOnly) {

        Thread thread = new Thread(() -> {
            Platform.runLater(() -> {
                view.displayProperties(primaryStage, properties, availableOnly);
            });
        });
        thread.start();
    }
}

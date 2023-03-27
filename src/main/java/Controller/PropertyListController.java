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
import View.PropertyListView;
import com.example.demo6.Main;
import javafx.stage.Stage;

import java.util.List;

public class PropertyListController {
    private final Main propertyManager;
    private final PropertyListView propertyListView;

    public PropertyListController(Main propertyManager, PropertyListView propertyListView) {
        this.propertyManager = propertyManager;
        this.propertyListView = propertyListView;
    }

    public void displayProperties(Stage primaryStage) {
        List<Property> properties = Main.properties;
        propertyListView.start(primaryStage,properties);
    }
}

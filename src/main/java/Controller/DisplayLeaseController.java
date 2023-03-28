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

import Model.Lease;
import View.DisplayLeaseView;
import com.example.demo6.Main;
import javafx.stage.Stage;

import java.util.List;

public class DisplayLeaseController {
    private final Main propertyManager;
    private final DisplayLeaseView displayLeaseView;

    public DisplayLeaseController(Main propertyManager, DisplayLeaseView displayLeaseView) {
        this.propertyManager = propertyManager;
        this.displayLeaseView = displayLeaseView;
    }

    public void displayLeases(Stage primaryStage) {
        List<Lease> leases = Main.leases;
        displayLeaseView.displayLeases(primaryStage, leases);
    }
}

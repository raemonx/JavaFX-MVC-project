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
import View.DisplayRentLeaseView;
import com.example.demo6.Main;
import javafx.stage.Stage;

import java.util.List;

import static com.example.demo6.Main.leases;

public class DisplayRentLeaseController {
    private final Main propertyManager;
    private final DisplayRentLeaseView displayLeaseView;

    public DisplayRentLeaseController(Main propertyManager, DisplayRentLeaseView displayLeaseView) {
        this.propertyManager = propertyManager;
        this.displayLeaseView = displayLeaseView;
    }

    public void displayLeases(Stage primaryStage) {
        int leaseSelection =-1;
        List<Lease> leases = Main.leases;
        displayLeaseView.displayLeases(primaryStage, leases);
//        if(leases.size()!= 0){
//            leaseSelection = displayLeaseView.getSelection(Main.tenants.size());
//            boolean value = displayLeaseView.getBooleanValue();
//             Main.leases.get(leaseSelection-1).setRentPaid(value);
//        }
    }

    public void modify(int leaseSelection, String selectedOption) {
        if(leases.size()!= 0){
            boolean value;
            if(selectedOption.equals("Paid")) {
                value = true;
            }
            else {
                value = false;
            }
             leases.get(leaseSelection -1).setRentPaid(value);
        }
    }

}

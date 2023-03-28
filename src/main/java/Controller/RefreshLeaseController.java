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

import Model.RefreshLease;
import View.ResfreshLeaseView;
import com.example.demo6.Main;
import javafx.stage.Stage;

import java.util.Date;

public class RefreshLeaseController {

    private final ResfreshLeaseView view;

    public RefreshLeaseController(ResfreshLeaseView view) {
        this.view = view;
    }

    public void refreshLease(Stage primaryStage) {
        view.getDate(primaryStage);
    }

    public void refresh(Date date) {
        RefreshLease refresh = new RefreshLease();
        refresh.refresh(Main.leases, date);
    }
}

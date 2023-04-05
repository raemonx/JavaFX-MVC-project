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

import Model.Tenant;
import View.TenantListView;
import com.example.demo6.Main;
import javafx.stage.Stage;

import java.util.List;

public class TenantListController {
    private final Main propertyManager;
    private final TenantListView tenantListView;

    public TenantListController(Main propertyManager, TenantListView tenantListView) {
        this.propertyManager = propertyManager;
        this.tenantListView = tenantListView;
    }

    public void displayTenants(Stage primaryStage) {
        List<Tenant> tenants = Main.tenants;
        tenantListView.start(primaryStage, tenants);
    }
}

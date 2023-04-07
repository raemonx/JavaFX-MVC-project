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

import View.*;
import com.example.demo6.Main;
import javafx.application.Platform;
import javafx.stage.Stage;

import static com.example.demo6.Main.*;

public class MainMenuController {
    private final MainMenuView view;
    Main main = new Main();

    public MainMenuController(MainMenuView view) {
        this.view = view;
    }

    public void start(Stage primaryStage) throws Exception {
        view.start(primaryStage, result -> {
            if (result == 1) {
                AddPropertyMenuController addPropertyMenuController = new AddPropertyMenuController(new AddPropertyMenuView());
                addPropertyMenuController.start(primaryStage);
            } else if (result == 2) {
                CreateTenantController controller = new CreateTenantController(new CreateTenantView());
                controller.createTenant(primaryStage);
            } else if (result == 3) {
                // handle "Rent a unit" menu option
                RentPropertyController rentPropertyController = new RentPropertyController(main, new RentPropertyView(tenants));
                rentPropertyController.start(primaryStage);
            } else if (result == 4) {
                PropertyListController propertyListController = new PropertyListController(main, new PropertyListView(properties));
                propertyListController.displayProperties(primaryStage);
            } else if (result == 5) {
                TenantListController tenantListController = new TenantListController(main, new TenantListView(tenants));
                tenantListController.displayTenants(primaryStage);
            } else if (result == 6) {
                // handle "Display rented units" menu option
                PropertiesAvailableOrUnavailableController propertiesAvailableOrUnavailableController = new PropertiesAvailableOrUnavailableController(new PropertiesAvailableOrUnavailableView(properties));
                propertiesAvailableOrUnavailableController.displayProperties(primaryStage, Main.properties, false);
            } else if (result == 7) {
                // handle "Display vacant units" menu option
                PropertiesAvailableOrUnavailableController propertiesAvailableOrUnavailableController = new PropertiesAvailableOrUnavailableController(new PropertiesAvailableOrUnavailableView(properties));
                propertiesAvailableOrUnavailableController.displayProperties(primaryStage, Main.properties, true);
            } else if (result == 8) {
                DisplayLeaseController leaseController = new DisplayLeaseController(main, new DisplayLeaseView(leases));
                leaseController.displayLeases(primaryStage);
            } else if (result == 9) {
                //end lease manually as admin. or end lease when lease date expires
                RefreshLeaseController refreshLeaseController = new RefreshLeaseController(new ResfreshLeaseView());
                refreshLeaseController.refreshLease(primaryStage);
            } else if (result == 10) {
                DisplayRentLeaseController displayRentLeaseController = new DisplayRentLeaseController(main, new DisplayRentLeaseView(leases));
                displayRentLeaseController.displayLeases(primaryStage);
            } else if (result == 11) {
                // handle "Display unpaid leases" menu option
                RentPaidOrUnpaidController rentPaidOrUnpaidController = new RentPaidOrUnpaidController(new RentPaidOrUnpaidView(leases));
                rentPaidOrUnpaidController.displayPaidOrUnpaidLease(primaryStage, Main.leases, false);
            } else if (result == 12) {
                // handle "Display paid leases" menu option
                RentPaidOrUnpaidController rentPaidOrUnpaidController = new RentPaidOrUnpaidController(new RentPaidOrUnpaidView(leases));
                rentPaidOrUnpaidController.displayPaidOrUnpaidLease(primaryStage, Main.leases, true);
            } else if (result == 13) {
                Platform.exit();
            }
        });
    }
}

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
import View.*;
import com.example.demo6.Main;
import javafx.stage.Stage;

import static com.example.demo6.Main.properties;
import static com.example.demo6.Main.tenants;

public class MainMenuController {
    private final MainMenuView view;
    Main main = new Main();

    public MainMenuController(MainMenuView view) {
        this.view = view;
    }

    public void start(Stage primaryStage) throws Exception {
        int selection = -1;

        view.start(primaryStage, result -> {
            if (result == 1) {
                System.out.println(result);
                AddPropertyMenuController addPropertyMenuController = new AddPropertyMenuController(new AddPropertyMenuView());
                addPropertyMenuController.start(primaryStage);
            } else if (result == 2) {
                CreateTenantController controller = new CreateTenantController(new CreateTenantView());
                controller.createTenant(primaryStage);
            } else if (result == 4) {
                PropertyListController propertyListController = new PropertyListController(main, new PropertyListView(properties));
                propertyListController.displayProperties(primaryStage);
            } else if (result == 5) {
                TenantListController tenantListController = new TenantListController(main, new TenantListView(tenants));
                tenantListController.displayTenants(primaryStage);
            }
        });
    }
}

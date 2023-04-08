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
import Model.Tenant;
import Model.TenantInterface;
import View.RentPropertyView;
import com.example.demo6.Main;
import javafx.stage.Stage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RentPropertyController {
    private final Main propertyManager;
    private final RentPropertyView view;

    public RentPropertyController(Main propertyManager, RentPropertyView view) {
        this.view = view;
        this.propertyManager = propertyManager;
    }

    public void start(Stage primaryStage) {
        //Rent available property
        view.start(primaryStage, Main.tenants);
    }

    public void rent(Stage primaryStage, int tenantSelection, int propertySelection) {


        if (!(propertySelection > Main.properties.size())) {
            if (Main.properties.get(propertySelection - 1).isAvailable()) {
                view.getLeaseDetails(primaryStage, tenantSelection, propertySelection);
            } else {
                //Observer Pattern Implementation
                view.registeredtoObserver(primaryStage);
                //register a tenant
                Runnable task = () -> {
                    Main.properties.get(propertySelection - 1).registerTenant(Main.tenants.get(tenantSelection - 1));
                };
                Thread thread = new Thread(task);
                thread.start();

                }
            }


    }

    public void createLease(Stage primaryStage, String startDate, String endDate, String rentAmount, int tenantSelection, int propertySelection) throws ParseException {
        Runnable task = () -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
            Date startDate1 = null;
            try {
                startDate1 = dateFormat.parse(startDate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            Date endDate1 = null;
            try {
                endDate1 = dateFormat.parse(endDate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            double rentAmount1 = Double.parseDouble(rentAmount);
            Lease lease = new Lease(Main.tenants.get(tenantSelection - 1), Main.properties.get(propertySelection - 1), startDate1, endDate1, rentAmount1);
            Main.leases.add(lease);
            Main.tenants.get(tenantSelection - 1).addLease(lease);
            Main.properties.get(propertySelection - 1).setAvailability(false);

        };
        Thread thread = new Thread(task);
        thread.start();
    }
}

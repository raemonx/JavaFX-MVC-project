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
import Model.TenantInterface;
import View.CreateTenantView;
import com.example.demo6.Main;
import javafx.stage.Stage;

public class CreateTenantController {

    private final CreateTenantView view;

    public CreateTenantController(CreateTenantView view) {
        this.view = view;
    }

    public void createTenant(Stage primaryStage) {
        view.start(primaryStage);
    }

    public void handleFormData(String name, String email, String phone) {
        TenantInterface tenantPrototype = new Tenant("Name", "name@email.com", "0000000000");

        //clone the prototype and set the parameters
        Tenant tenant = tenantPrototype.clone();
        tenant.setName(name);
        tenant.setEmail(email);
        tenant.setPhone(phone);
        Main.tenants.add(tenant);
    }
}

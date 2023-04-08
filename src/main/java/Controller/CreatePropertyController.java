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

import Model.*;
import View.CreatePropertyView;
import com.example.demo6.Main;
import javafx.application.Platform;
import javafx.stage.Stage;


public class CreatePropertyController {
    private final CreatePropertyView view;

    public CreatePropertyController(CreatePropertyView view) {
        this.view = view;
    }

    public void createProperty(Stage primaryStage, int type) {
        view.start(primaryStage, type);
    }

    public void handleFormData(int type, String streetNumber, String streetName, String city, String state, String zipCode, int unitNumber, int numberOfBedrooms, int numberOfBathrooms, int squareFootage){

        Address address = new Address(streetName, city, state, zipCode);
        // Handle the creators on a new thread
        Thread thread = new Thread(() -> {

            Platform.runLater(() -> {
                String streetNo = "";
                if (streetNumber != null) {
                    streetNo = streetNumber;
                }
                if (type == 1) {
                    PropertyCreator creator = new ApartmentCreator();
                    Property property = creator.createProperty(streetNo, address, unitNumber, numberOfBedrooms, numberOfBathrooms, squareFootage);
                    Main.properties.add(property);
                } else if (type == 2) {
                    PropertyCreator creator = new CondoCreator();
                    Property property = creator.createProperty(streetNo, address, unitNumber, numberOfBedrooms, numberOfBathrooms, squareFootage);
                    Main.properties.add(property);
                } else if (type == 3) {
                    PropertyCreator creator = new HouseCreator();
                    Property property = creator.createProperty(streetNo, address, unitNumber, numberOfBedrooms, numberOfBathrooms, squareFootage);
                    Main.properties.add(property);
                }

            });

        });
        thread.start();

    }
}

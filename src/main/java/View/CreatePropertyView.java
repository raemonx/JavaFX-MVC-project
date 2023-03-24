package View;

import Controller.CreatePropertyController;
import Controller.MainMenuController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CreatePropertyView {

    public void start(Stage primaryStage, int type) {
        // Create the GridPane
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        // Add the labels and text fields
        Label streetNumberLabel = null;
        TextField streetNumberField;
        if (type != 1) {
            streetNumberLabel = new Label("Street Number");
            streetNumberField = new TextField();
        } else {
            streetNumberField = null;
        }
        Label streetNameLabel = new Label("Street Name");
        TextField streetNameField = new TextField();
        Label cityLabel = new Label("City");
        TextField cityField = new TextField();
        Label stateLabel = new Label("State");
        TextField stateField = new TextField();
        Label zipCodeLabel = new Label("Zip Code");
        TextField zipCodeField = new TextField();
        Label unitLabel = null;
        TextField unitField;
        if (type != 3) {
            unitLabel = new Label("Unit/Apartment Number");
            unitField = new TextField();
        } else {
            unitField = null;
        }

        Label bedroomsLabel = new Label("Number of Bedrooms");
        TextField bedroomsField = new TextField();
        Label bathroomsLabel = new Label("Number of Bathrooms");
        TextField bathroomsField = new TextField();
        Label sqftLabel = new Label("Square Footage");
        TextField sqftField = new TextField();
        Button submitBtn = new Button("Submit");

        // Add the labels and text fields to the GridPane
        if (type != 1) {
            grid.add(streetNumberLabel, 0, 0);
            grid.add(streetNumberField, 1, 0);
        }
        grid.add(streetNameLabel, 0, 1);
        grid.add(streetNameField, 1, 1);
        grid.add(cityLabel, 0, 2);
        grid.add(cityField, 1, 2);
        grid.add(stateLabel, 0, 3);
        grid.add(stateField, 1, 3);
        grid.add(zipCodeLabel, 0, 4);
        grid.add(zipCodeField, 1, 4);
        if (type != 3) {
            grid.add(unitLabel, 0, 5);
            grid.add(unitField, 1, 5);
        }
        grid.add(bedroomsLabel, 0, 6);
        grid.add(bedroomsField, 1, 6);
        grid.add(bathroomsLabel, 0, 7);
        grid.add(bathroomsField, 1, 7);
        grid.add(sqftLabel, 0, 8);
        grid.add(sqftField, 1, 8);
        grid.add(submitBtn, 1, 9);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Add Property Details");
        primaryStage.show();

        var ref = new Object() {
            String streetNumber;
        };
        submitBtn.setOnAction(e -> {
            if (type != 1) {
                ref.streetNumber = streetNumberField.getText();
            }

            String streetName = streetNameField.getText();
            String city = cityField.getText();
            String state = stateField.getText();
            String zipCode = zipCodeField.getText();
            int unit = 0;
            if (type != 3) {
                unit = Integer.parseInt(unitField.getText());
            }

            int bedrooms = Integer.parseInt(bedroomsField.getText());
            int bathrooms = Integer.parseInt(bathroomsField.getText());
            int sqft = Integer.parseInt(sqftField.getText());

            CreatePropertyController controller = new CreatePropertyController(new CreatePropertyView());
            controller.handleFormData(type, ref.streetNumber, streetName, city, state, zipCode, unit, bedrooms, bathrooms, sqft);
            MainMenuController mainMenuController = new MainMenuController(new MainMenuView());

            try {
                mainMenuController.start(primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}

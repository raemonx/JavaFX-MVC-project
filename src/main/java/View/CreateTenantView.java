package View;

import Controller.CreatePropertyController;
import Controller.CreateTenantController;
import Controller.MainMenuController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateTenantView {

    public void start(Stage primaryStage) {
        // Create the GridPane
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        // Add the labels and text fields
        Label nameLabel = new Label("Name");
        TextField nameField = new TextField();
        Label emailLabel = new Label("Email");
        TextField emailField = new TextField();
        Label phoneLabel = new Label("Phone");
        TextField phoneField = new TextField();
        Button submitBtn = new Button("Submit");

        grid.add(nameLabel, 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(emailLabel, 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(phoneLabel, 0, 3);
        grid.add(phoneField, 1, 3);
        grid.add(submitBtn, 1, 4);

        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10, 30, 30, 30));

        Text title = new Text();
        title.setText("Add Property Details");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        title.setFill(Color.web("#0076a3"));

        VBox vbox = new VBox(title, grid, submitBtn);
        vbox.setSpacing(20);
        vbox.setPrefWidth(400);
        bp.setCenter(vbox);

        Scene scene = new Scene(bp, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Property Management System");
        primaryStage.show();

        submitBtn.setOnAction(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            CreateTenantController controller = new CreateTenantController(new CreateTenantView());
            controller.handleFormData(name, email, phone);
            MainMenuController mainMenuController = new MainMenuController(new MainMenuView());
            try {
                mainMenuController.start(primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
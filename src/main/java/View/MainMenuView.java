package View;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Controller.Callback;

import java.util.concurrent.atomic.AtomicInteger;

public class MainMenuView {

    public void start(Stage primaryStage, Callback callback) throws Exception {
        Group root = new Group();
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10, 30, 30, 30));

        Text title = new Text();
        title.setText("Welcome to the \nProperty Management System");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        title.setFill(Color.web("#0076a3"));

        Text text = new Text();
        text.setText("\nChoose one of the following options: \n"
                + "1. Add a property \n"
                + "2. Add a tenant \n"
                + "3. Rent a unit \n"
                + "4. Display properties \n"
                + "5. Display tenants \n"
                + "6. Display rented units \n"
                + "7. Display vacant units \n"
                + "8. Display all leases \n"
                + "9. Make available \n"
                + "10. Modify Rent paid for property \n"
                + "11. List all leases which rent are unpaid for \n"
                + "12. List all leases which rent are paid for \n"
                + "13. Exit \n");
        TextField inputField = new TextField();
        inputField.setPromptText("Enter your choice");
        inputField.setPrefWidth(200);
        inputField.setMaxWidth(Double.MAX_VALUE);

        Button submitButton = new Button("Submit");
        AtomicInteger input = new AtomicInteger();
        submitButton.setOnAction(e -> {
            String value = inputField.getText();
            input.set(Integer.parseInt(value));
            try {
                callback.onActionComplete(input.get());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        VBox vbox = new VBox(title, text, inputField, submitButton);
        vbox.setSpacing(20);
        vbox.setMaxWidth(Double.MAX_VALUE);
        bp.setCenter(vbox);

        root.getChildren().add(bp);
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Property Management System");
        primaryStage.show();
    }
}
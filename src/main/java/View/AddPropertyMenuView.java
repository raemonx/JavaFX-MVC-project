package View;

import Controller.Callback;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class AddPropertyMenuView {
    public void start(Stage primaryStage, Callback callback) throws Exception {
        Group root = new Group();

        Text text = new Text();
        text.setText("\nChoose one of the following options: \n"
                + "1. Apartment \n"
                + "2. Condo \n"
                + "3. House \n"
                + "4. Back to Main Menu \n");

        TextField inputField = new TextField();
        inputField.setPromptText("Enter your choice");
        inputField.setLayoutX(50);
        inputField.setLayoutY(250);

        Button submitButton = new Button("Submit");
        submitButton.setLayoutX(200);
        submitButton.setLayoutY(250);
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

        root.getChildren().addAll(text, inputField, submitButton);
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Property Management System");
        primaryStage.show();
    }
}

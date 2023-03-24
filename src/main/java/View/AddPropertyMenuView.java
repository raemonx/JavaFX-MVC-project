package View;

import Controller.Callback;
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

import java.util.concurrent.atomic.AtomicInteger;

public class AddPropertyMenuView {
    public void start(Stage primaryStage, Callback callback) throws Exception {
        Group root = new Group();

        Text title = new Text();
        title.setText("Add a Property");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        title.setFill(Color.web("#0076a3"));

        Text text = new Text();
        text.setText("\nChoose one of the following options: \n"
                + "1. Apartment \n"
                + "2. Condo \n"
                + "3. House \n"
                + "4. Back to Main Menu \n");

        TextField inputField = new TextField();
        inputField.setPromptText("Enter your choice");
        inputField.setPrefWidth(200);

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

        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10, 30, 30, 30));

        VBox vbox = new VBox(title, text, inputField, submitButton);
        vbox.setSpacing(20);
        vbox.setPrefWidth(400);
        bp.setCenter(vbox);

        root.getChildren().add(bp);
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Property Management System");
        primaryStage.show();
    }
}
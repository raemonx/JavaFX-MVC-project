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
package View;

import Controller.MainMenuController;
import Controller.RefreshLeaseController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ResfreshLeaseView {

    public void getDate(Stage primaryStage) {
        TextField currentDateField = new TextField();
        currentDateField.setPromptText("Enter current date");

        Button button = new Button("Submit");
        button.setOnAction(event -> {
            String currentDate = currentDateField.getText();
            RefreshLeaseController refreshLeaseController = new RefreshLeaseController(new ResfreshLeaseView());
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                Date currentDate1 = dateFormat.parse(currentDate);
                refreshLeaseController.refresh(currentDate1);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            MainMenuController mainMenuController = new MainMenuController(new MainMenuView());
            try {
                mainMenuController.start(primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        HBox hbox = new HBox(currentDateField, button);
        hbox.setPadding(new Insets(10, 0, 0, 0));
        hbox.setSpacing(10);

        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(20));
        vbox.setBackground(new Background(new BackgroundFill(Color.web("#f2f2f2"), CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.setMaxWidth(Double.MAX_VALUE);
        vbox.getChildren().addAll(new Text(""), hbox);

        Text title = new Text("Enter current date");

        title.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        title.setFill(Color.web("#0076a3"));

        BorderPane root = new BorderPane();
        root.setCenter(vbox);
        root.setTop(title);
        root.setPadding(new Insets(10, 30, 10, 30));

        Scene scene = new Scene(root, 500, 200);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

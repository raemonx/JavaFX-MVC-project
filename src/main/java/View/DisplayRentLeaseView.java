package View;

import Controller.DisplayRentLeaseController;
import Controller.MainMenuController;
import Model.Lease;
import com.example.demo6.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class DisplayRentLeaseView {
    private ObservableList<Lease> leases;

    public DisplayRentLeaseView(List<Lease> leases) {
        this.leases = FXCollections.observableArrayList(leases);
    }

    public void displayLeases(Stage primaryStage, List<Lease> leases1) {
        this.leases = FXCollections.observableArrayList(leases1);

        ListView<String> listView = new ListView<>();
        for (int i = 0; i < leases.size(); i++) {
            String leaseText = "Lease " + (i + 1) + ": \n" + leases.get(i).toString();
            listView.getItems().add(leaseText);
        }

        // Add text field
        TextField textField = new TextField();
        textField.setPromptText("Enter a value");

        // Add radio buttons
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton radioButton1 = new RadioButton("Paid");
        RadioButton radioButton2 = new RadioButton("Unpaid");
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);

        // Add submit button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> {
            String value = textField.getText();
            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            if (selectedRadioButton != null && value!=null) {
                String selectedOption = selectedRadioButton.getText();
                // Do something with the value and selected option
                System.out.println("Value: " + value + ", Selected option: " + selectedOption);
                DisplayRentLeaseController displayRentLeaseController = new DisplayRentLeaseController(new Main(),new DisplayRentLeaseView(leases1));
                displayRentLeaseController.modify(Integer.parseInt(value), selectedOption);
            }
            MainMenuController mainMenuController = new MainMenuController(new MainMenuView());
            try {
                mainMenuController.start(primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        HBox hbox = new HBox(submitButton);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(10, 0, 0, 0));

        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(20));
        vbox.setBackground(new Background(new BackgroundFill(Color.web("#f2f2f2"), CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.setMaxWidth(Double.MAX_VALUE);
        vbox.getChildren().addAll(new Text(""), listView, textField, radioButton1, radioButton2, hbox);

        Text title = new Text(" Modify Lease Details:");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        title.setFill(Color.web("#0076a3"));

        BorderPane root = new BorderPane();
        root.setCenter(vbox);
        root.setTop(title);
        root.setPadding(new Insets(10, 30, 10, 30));

        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

package View;

import Controller.MainMenuController;
import Model.Lease;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class RentPaidOrUnpaidView {
    private ObservableList<Lease> leases;

    public RentPaidOrUnpaidView(List<Lease> leases) {
        this.leases = FXCollections.observableArrayList(leases);
    }

    public void displayLeases(Stage primaryStage, List<Lease> leases1, boolean rentPaid) {
        this.leases = FXCollections.observableArrayList();

        for (Lease lease : leases1) {
            if (lease.isRentPaid() == rentPaid) {
                this.leases.add(lease);
            }
        }

        ListView<String> listView = new ListView<>();
        for (int i = 0; i < this.leases.size(); i++) {
            String leaseText = "Lease " + (i + 1) + ": \n" + this.leases.get(i).toString();
            listView.getItems().add(leaseText);
        }

        Button button = new Button("Go Back to Main Menu");
        button.setOnAction(event -> {
            MainMenuController mainMenuController = new MainMenuController(new MainMenuView());
            try {
                mainMenuController.start(primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        HBox hbox = new HBox(button);
        hbox.setPadding(new Insets(10, 0, 0, 0));

        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(20));
        vbox.setBackground(new Background(new BackgroundFill(Color.web("#f2f2f2"), CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.setMaxWidth(Double.MAX_VALUE);
        vbox.getChildren().addAll(new Text(""), listView, hbox);

        Text title = new Text(rentPaid ? "Leases with Rent Paid" : "Leases with Rent Unpaid");
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

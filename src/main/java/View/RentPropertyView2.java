package View;

import Controller.MainMenuController;
import Controller.RentPropertyController;
import Model.Property;
import com.example.demo6.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

import static com.example.demo6.Main.tenants;

public class RentPropertyView2 {
    private ObservableList<Property> properties;

    public RentPropertyView2(List<Property> properties) {
        this.properties = FXCollections.observableArrayList(properties);
    }

    public void start(Stage primaryStage, List<Property> properties1, int tenantSelection) {
        this.properties = FXCollections.observableArrayList(properties1);
        ListView<Property> listView = new ListView<>(properties);

        // Add numbering to the properties in the list
        listView.setCellFactory(param -> new ListViewCell());
        TextField inputBox = new TextField();
        inputBox.setPromptText("Choose your option");

        Button button = new Button("Go Back to Main Menu");
        button.setOnAction(event -> {
            MainMenuController mainMenuController = new MainMenuController(new MainMenuView());
            try {
                mainMenuController.start(primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        Button nextButton = new Button("Rent");
        nextButton.setOnAction(event -> {
            try {
                int propertySelection = Integer.parseInt(inputBox.getText());
                // do something with the number

                RentPropertyController rentPropertyController = new RentPropertyController(new Main(), new RentPropertyView(tenants));
                rentPropertyController.rent(primaryStage, tenantSelection, propertySelection);
            } catch (NumberFormatException ex) {
                // handle invalid input
                System.err.println("Invalid number: " + inputBox.getText());
            }
        });

        HBox hbox = new HBox(inputBox, nextButton, button);
        hbox.setPadding(new Insets(10, 0, 0, 0));

        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(20));
        vbox.setBackground(new Background(new BackgroundFill(Color.web("#f2f2f2"), CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.setMaxWidth(Double.MAX_VALUE);
        vbox.getChildren().addAll(new Text(""), listView, hbox);

        Text title = new Text("Property List");
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

    // Define a ListViewCell class to display properties with numbering
    private class ListViewCell extends javafx.scene.control.ListCell<Property> {
        @Override
        protected void updateItem(Property item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setText(null);
            } else {
                int index = getIndex() + 1;
                Label label = new Label(index + ". " + item.toString());
                setGraphic(label);
            }
        }
    }
}

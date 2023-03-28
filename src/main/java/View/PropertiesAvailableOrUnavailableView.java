package View;

import Controller.MainMenuController;
import Model.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
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
import java.util.stream.Collectors;

public class PropertiesAvailableOrUnavailableView {
    private ObservableList<Property> properties;

    public PropertiesAvailableOrUnavailableView(List<Property> properties) {
        this.properties = FXCollections.observableArrayList(properties);
    }

    public void displayProperties(Stage primaryStage, List<Property> properties1, boolean available) {
        this.properties = FXCollections.observableArrayList(properties1);

        // Filter the properties based on availability
        List<Property> filteredProperties = properties1.stream()
                .filter(p -> p.isAvailable() == available)
                .collect(Collectors.toList());
        ListView<Property> listView = new ListView<>(FXCollections.observableArrayList(filteredProperties));

        // Set the cell factory to include the index of the property in the list
        listView.setCellFactory(param -> new ListCell<Property>() {
            @Override
            protected void updateItem(Property item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    int index = getIndex() + 1;
                    setText(index + ". " + item.toString());
                }
            }
        });

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

        String availability = available ? "Vacant" : "Rented";
        Text title = new Text(availability + " Properties");
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

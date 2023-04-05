package View;

import Controller.MainMenuController;
import Controller.RentPropertyController;
import Model.Tenant;
import com.example.demo6.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.ParseException;
import java.util.List;

import static com.example.demo6.Main.properties;

public class RentPropertyView {
    private ObservableList<Tenant> tenants;

    public RentPropertyView(List<Tenant> tenants) {
        this.tenants = FXCollections.observableArrayList(tenants);
    }

    public void start(Stage primaryStage, List<Tenant> tenants1) {
        this.tenants = FXCollections.observableArrayList(tenants1);
        ListView<Tenant> listView = new ListView<>(tenants);

        // set custom cell factory to display tenant information
        listView.setCellFactory(lv -> new ListCell<Tenant>() {
            @Override
            public void updateItem(Tenant tenant, boolean empty) {
                super.updateItem(tenant, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    // create a VBox to display the tenant information
                    VBox vbox = new VBox();
                    vbox.setSpacing(5);

                    // add tenant number
                    int index = getIndex() + 1;
                    Label numberLabel = new Label("Tenant " + index + ".");
                    numberLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
                    vbox.getChildren().add(numberLabel);

                    // add tenant name
                    Label nameLabel = new Label("Name: " + tenant.getName());
                    nameLabel.setFont(Font.font("Verdana", 14));
                    vbox.getChildren().add(nameLabel);

                    // add tenant email
                    Label emailLabel = new Label("Email: " + tenant.getEmail());
                    emailLabel.setFont(Font.font("Verdana", 14));
                    vbox.getChildren().add(emailLabel);

                    // add tenant phone
                    Label phoneLabel = new Label("Phone: " + tenant.getPhone());
                    phoneLabel.setFont(Font.font("Verdana", 14));
                    vbox.getChildren().add(phoneLabel);

                    // add tenant leases
                    Label leasesLabel = new Label("Leases: ");
                    leasesLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
                    vbox.getChildren().add(leasesLabel);

                    String leases = tenant.getLeases();
                    Label leasesText = new Label(leases);
                    leasesText.setFont(Font.font("Verdana", 14));
                    vbox.getChildren().add(leasesText);

                    setGraphic(vbox);
                }
            }
        });

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

        Button nextButton = new Button("Next");
        nextButton.setOnAction(event -> {
            try {
                int number = Integer.parseInt(inputBox.getText());
                if (!(number > Main.tenants.size())) {
                    RentPropertyView2 rentPropertyView2 = new RentPropertyView2(properties);
                    rentPropertyView2.start(primaryStage, properties, number);
                }

            } catch (NumberFormatException ex) {
                // handle invalid input
                System.err.println("Invalid number: " + inputBox.getText());
            }
        });

        HBox hbox = new HBox(inputBox, nextButton, button);
        hbox.setPadding(new Insets(10, 0, 0, 0));
        hbox.setSpacing(10);

        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(20));
        vbox.setBackground(new Background(new BackgroundFill(Color.web("#f2f2f2"), CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.setMaxWidth(Double.MAX_VALUE);
        vbox.getChildren().addAll(new Text(""), listView, hbox);

        Text title = new Text("Tenant List");
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

    public void getLeaseDetails(Stage primaryStage, int tenantSelection, int propertySelection) {
        TextField startDateField = new TextField();
        startDateField.setPromptText("Enter start date");

        TextField endDateField = new TextField();
        endDateField.setPromptText("Enter end date");

        TextField rentField = new TextField();
        rentField.setPromptText("Enter rent amount");

        Button button = new Button("Submit");
        button.setOnAction(event -> {
            String startDate = startDateField.getText();
            String endDate = endDateField.getText();
            String rentAmount = rentField.getText();
            RentPropertyController rentPropertyController = new RentPropertyController(new Main(), new RentPropertyView(tenants));
            try {
                rentPropertyController.createLease(primaryStage, startDate, endDate, rentAmount, tenantSelection, propertySelection);
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

        HBox hbox = new HBox(startDateField, endDateField, rentField, button);
        hbox.setPadding(new Insets(10, 0, 0, 0));
        hbox.setSpacing(10);

        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(20));
        vbox.setBackground(new Background(new BackgroundFill(Color.web("#f2f2f2"), CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.setMaxWidth(Double.MAX_VALUE);
        vbox.getChildren().addAll(new Text(""), hbox);

        Text title = new Text("Enter start date");

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

    public void registeredtoObserver(Stage primaryStage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Unit Occupied");
        alert.setHeaderText(null);
        alert.setContentText("The property is occupied right now. Tenant will be notified when the unit is available.");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                MainMenuController mainMenuController = new MainMenuController(new MainMenuView());
                try {
                    mainMenuController.start(primaryStage);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}

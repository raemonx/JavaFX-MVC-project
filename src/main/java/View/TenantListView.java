package View;

import Controller.MainMenuController;
import Model.Property;
import Model.Tenant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class TenantListView {
    private ObservableList<Tenant> tenants;

    public TenantListView(List<Tenant> tenants) {
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
                    Label numberLabel = new Label("Tenant "+index + ".");
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
}

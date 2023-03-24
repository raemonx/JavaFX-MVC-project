package com.example.demo6;

import Controller.MainMenuController;
import Model.Lease;
import Model.Property;
import Model.Tenant;
import View.MainMenuView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    public static List<Property> properties = new ArrayList<>();
    public static List<Tenant> tenants = new ArrayList<>();
    public static List<Lease> leases = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {
        // Create an instance of controller
        MainMenuController controller = new MainMenuController(new MainMenuView());

        // Call the show() method of the controller to display the view
        controller.start(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
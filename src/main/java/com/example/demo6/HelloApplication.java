package com.example.demo6;

import Controller.MainMenuController;
import View.MainMenuView;
import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Create an instance of your controller
        MainMenuController controller = new MainMenuController(new MainMenuView());

        // Call the show() method of the controller to display the view
        controller.start(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
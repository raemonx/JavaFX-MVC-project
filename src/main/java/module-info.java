module com.example.demo6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo6 to javafx.fxml;
    exports com.example.demo6;
    exports View;
    opens View to javafx.fxml;
    exports com.example.demo6.SetClass;
    opens com.example.demo6.SetClass to javafx.fxml;
}
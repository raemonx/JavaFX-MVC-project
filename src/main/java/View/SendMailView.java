package View;

import javafx.scene.control.Alert;

public class SendMailView {
    public void display(String email, String address) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mail Sent");
        alert.setHeaderText(null);
        alert.setContentText("Mail sent successfully to " + email + "\nProperty " + address + " is now available.");
        alert.showAndWait();
    }
}

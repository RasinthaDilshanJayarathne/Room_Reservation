package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ReceptionistHomeFormController {
    public AnchorPane homePageContext;

    public void goToBookingPage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AvailabilityForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) homePageContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void goToBack(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) homePageContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void goToMaintainance(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MaintainanceForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) homePageContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}

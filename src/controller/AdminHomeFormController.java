package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AdminHomeFormController {
    public AnchorPane roomsContext;

    public void goToBack(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) roomsContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
    public void goToRoomsPage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/BookingDetails.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) roomsContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void goToIncomePage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/IncomeReportForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) roomsContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void goToMealsPage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MealsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) roomsContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}

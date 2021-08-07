package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Customer;
import view.tm.CustomerTM;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class BookingDetailsController {
    public AnchorPane detailsContext;
    public TableView tblDetails;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colIn;

    public void initialize(){
        tblDetails.setItems(FXCollections.observableArrayList(RoomsFormController.customerArrayList));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
    }

    public void goToBackHome(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AdminHomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) detailsContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void goToAddRooms(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddRoomForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) detailsContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}

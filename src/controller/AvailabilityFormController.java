package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Availability;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class AvailabilityFormController {
    public AnchorPane availabilityContext;
    public TableColumn colId;
    public TableColumn colAvailable;
    public JFXComboBox<String> cmbRoom;
    public TableColumn colNotAvailable;
    public TableView tblAvailability;

    ArrayList<Availability>availabilityArrayList=new ArrayList<>();
    {
        availabilityArrayList.add(new Availability("No","Yes","R001"));
        availabilityArrayList.add(new Availability("Yes","No","R002"));
        availabilityArrayList.add(new Availability("Yes","No","R003"));
        availabilityArrayList.add(new Availability("No","Yes","R004"));
        availabilityArrayList.add(new Availability("Yes","No","R005"));

    }

    public void initialize(){

        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colAvailable.setCellValueFactory(new PropertyValueFactory("txtAvailable"));
        colNotAvailable.setCellValueFactory(new PropertyValueFactory("txtNotAvailable"));

        tblAvailability.setItems(FXCollections.observableArrayList(availabilityArrayList));

        cmbRoom.getItems().addAll(
                "Single Rooms",
                "Double Rooms",
                "Triple Rooms",
                "Quad Rooms"
        );
        cmbRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        });

    }


    public void goToRoomPage(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/RoomsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) availabilityContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

}

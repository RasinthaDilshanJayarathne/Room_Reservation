package controller;

import com.jfoenix.controls.JFXTextField;
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
import model.Rooms;
import view.tm.CustomerTM;
import view.tm.RoomTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class AddRoomFormController {
    public JFXTextField txtType;
    public JFXTextField txtCharges;
    public JFXTextField txtRId;
    public JFXTextField txtOffers;
    public AnchorPane addRoomContext;
    public TableView tblAdd;
    public TableColumn colId;
    public TableColumn colType;
    public TableColumn colCharges;
    public TableColumn colOffers;
    public TableColumn colOption;

    static ArrayList<Rooms> roomsArrayList = new ArrayList();

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colCharges.setCellValueFactory(new PropertyValueFactory<>("charges"));
        colOffers.setCellValueFactory(new PropertyValueFactory<>("offers"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));

    }

    public void goToBack(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AdminHomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) addRoomContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void moveToCharges(ActionEvent actionEvent) {
        txtCharges.requestFocus();
    }

    public void moveToOffers(ActionEvent actionEvent) {
        txtOffers.requestFocus();
    }

    public void moveToType(ActionEvent actionEvent) {
        txtType.requestFocus();
    }

    public void OnActionSave(ActionEvent actionEvent) {
        Rooms rooms = new Rooms(txtType.getText(),txtCharges.getText(),txtRId.getText(),txtOffers.getText());
        txtType.clear();
        txtOffers.clear();
        txtCharges.clear();
        txtRId.clear();


        if (roomsArrayList.add(rooms)){
            loadAllRooms();
            new Alert(Alert.AlertType.CONFIRMATION,"Saved..", ButtonType.CLOSE).show();
        }else {
            new Alert(Alert.AlertType.WARNING, "Try Again..", ButtonType.CLOSE).show();
        }
    }

    public void loadAllRooms(){
        ObservableList<RoomTM> tmObservableList= FXCollections.observableArrayList();
        for (Rooms temp : roomsArrayList){
            Button btn=new Button("Delete");
            tmObservableList.add(new RoomTM(temp.getId(),temp.getCharges(),temp.getOffers(),temp.getType(),btn));

            btn.setOnAction((e)->{
                ButtonType yes = new ButtonType("Yes",ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("No",ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you want to delete Customer ?",yes,no);
                alert.setTitle("Confirmation Alert");
                Optional<ButtonType> result = alert.showAndWait();

                if(result.orElse(no)==yes) {
                    roomsArrayList.remove(temp);
                    loadAllRooms();
                }else{

                }
            });
        }
        tblAdd.setItems(tmObservableList);
    }

}

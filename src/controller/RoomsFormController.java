package controller;

import com.jfoenix.controls.JFXComboBox;
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
import view.tm.CustomerTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class RoomsFormController {
    public AnchorPane roomContext;
    public TableView tblRoomDetails;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colNic;
    public TableColumn colContact;
    public TableColumn colEmail;
    public TableColumn colAddress;
    public TableColumn colOption;
    public JFXTextField txtName;
    public JFXTextField txtNIC;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtId;
    public JFXTextField txtContact;
    public TableColumn colOption1;
    public TableColumn colIn;

    static ArrayList<Customer>customerArrayList = new ArrayList();
    public JFXTextField txtIn;
    public JFXComboBox<String> cmbMeal;

    public void initialize() throws IOException {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNic .setCellValueFactory(new PropertyValueFactory<>("nic"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        colOption1.setCellValueFactory(new PropertyValueFactory<>("btn1"));


        cmbMeal.getItems().addAll(
                "Local meals",
                "Chinese meals",
                "French meals"
        );
        cmbMeal.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        });

        tblRoomDetails.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                loadCustomerData((CustomerTM) newValue);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void loadCustomerData(CustomerTM tm) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/CustomerDataForm.fxml"));
        Parent parent = loader.load();
        CustomerDataFormController controller = loader.getController();
        controller.setData(tm);
        Scene scene = new Scene(parent);
        Stage stage =new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void goToBck(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ReceptionistHomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) roomContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void saveOnAction(ActionEvent actionEvent) {

        Customer customer = new Customer(txtId.getText(),txtName.getText(),txtNIC.getText(),txtContact.getText(),txtEmail.getText(),txtAddress.getText(),txtIn.getText());
        txtId.clear();
        txtName.clear();
        txtNIC.clear();
        txtContact.clear();
        txtEmail.clear();
        txtAddress.clear();
        txtIn.clear();

        if (customerArrayList.add(customer)){
            loadAllCustomer();
            new Alert(Alert.AlertType.CONFIRMATION,"Saved..",ButtonType.CLOSE).show();
        }else {
            new Alert(Alert.AlertType.WARNING, "Try Again..", ButtonType.CLOSE).show();
        }
    }

    public void loadAllCustomer(){
        ObservableList<CustomerTM>tmObservableList= FXCollections.observableArrayList();
        for (Customer temp : customerArrayList){
            Button btn=new Button("Delete");
            Button btn1=new Button("Edit");
            tmObservableList.add(new CustomerTM(temp.getId(),temp.getName(),temp.getNic(),temp.getContact(),temp.getEmail(),temp.getAddress(),temp.getCheckIn(),btn,btn1));

            btn.setOnAction((e)->{
                ButtonType yes = new ButtonType("Yes",ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("No",ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you want to delete Customer ?",yes,no);
                alert.setTitle("Confirmation Alert");
                Optional<ButtonType> result = alert.showAndWait();

                if(result.orElse(no)==yes) {
                    customerArrayList.remove(temp);
                    loadAllCustomer();
                }else{

                }
            });
        }
        tblRoomDetails.setItems(tmObservableList);
    }

    public void moveToName(ActionEvent actionEvent) {
        txtName.requestFocus();
    }

    public void moveToAddress(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void moveToEmail(ActionEvent actionEvent) {
        txtEmail.requestFocus();
    }

    public void moveToPhoneNo(ActionEvent actionEvent) {
        txtContact.requestFocus();
    }

    public void moveToNic(ActionEvent actionEvent) {
        txtNIC.requestFocus();
    }

    public void moveToId(ActionEvent actionEvent) {
        txtId.requestFocus();
    }

    public void goToLogin(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) roomContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}

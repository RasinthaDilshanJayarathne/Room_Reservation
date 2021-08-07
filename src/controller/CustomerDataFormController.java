package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import view.tm.CustomerTM;

public class CustomerDataFormController {
    public AnchorPane customerDataContext;
    public JFXTextField txtRId;
    public JFXTextField txtName;
    public JFXTextField txtNic;
    public JFXTextField txtContact;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtIn;
    public JFXTextField txtOut;

    public  void setData(CustomerTM tm){
        txtRId.setText(tm.getId());
        txtName.setText(tm.getName());
        txtNic.setText(tm.getNic());
        txtContact.setText(tm.getContact());
        txtEmail.setText(tm.getEmail());
        txtAddress.setText(tm.getAddress());
        txtIn.setText(tm.getAddress());
        txtOut.setText(tm.getAddress());
        System.out.println(tm);
    }

    public void sendingEmail(ActionEvent actionEvent) {
        new Alert(Alert.AlertType.CONFIRMATION,"Sending..", ButtonType.CLOSE).show();
    }
}

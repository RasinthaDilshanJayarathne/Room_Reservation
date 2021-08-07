package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    public AnchorPane loginContext;
    public JFXTextField txtName;
    public JFXPasswordField txtPassword;
    public Label label;

    public void goToHome(ActionEvent actionEvent) throws IOException {
        if(txtName.getText().equals("Admin") & !txtPassword.getText().isEmpty()){
            if(txtPassword.getText().equals("0000") ){

                label.setText("Thank you for your Login");
                URL resource = getClass().getResource("../view/AdminHomeForm.fxml");
                Parent load = FXMLLoader.load(resource);
                Stage window = (Stage) loginContext.getScene().getWindow();
                window.setScene(new Scene(load));
            }
        }else{
            label.setText("Enter correct username or password");
        }
        if(txtName.getText().equals("Receptionist") & !txtPassword.getText().isEmpty()){
            if(txtPassword.getText().equals("1111") & txtName.getText().equals("Receptionist")){

                label.setText("Thank you for your Login");
                URL resource = getClass().getResource("../view/ReceptionistHomeForm.fxml");
                Parent load = FXMLLoader.load(resource);
                Stage window = (Stage) loginContext.getScene().getWindow();
                window.setScene(new Scene(load));
            }
        }else{
            label.setText("Enter correct username or password");
        }
    }
    public void moveToPassword(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }

    public void backToHome(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/HomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) loginContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}

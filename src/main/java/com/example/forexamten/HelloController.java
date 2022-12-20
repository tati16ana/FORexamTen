package com.example.forexamten;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloController {
    @FXML
    private Label label;

    @FXML
    private TextField loginField;

    @FXML
    private TextField textFieldTwo;

    @FXML
    private PasswordField passField;

    @FXML
    private CheckBox checkBox;

    @FXML
    private Button buttonOne;

    @FXML
    public void visiblePass(){
        if(checkBox.isSelected()){
            textFieldTwo.setText(passField.getText());
            textFieldTwo.setVisible(true);
            passField.setVisible(false);
        } else{
            passField.setText(textFieldTwo.getText());
            passField.setVisible(true);
            textFieldTwo.setVisible(false);
        }
    }


    @FXML
    public void login(ActionEvent event) throws SQLException, IOException{
        if (loginField.getText().isEmpty()){
            label.setText("Введите логин");
        }
        if (passField.getText().isEmpty()){
            label.setText("Введите пароль");
        }

        String login = loginField.getText();
        String password = passField.getText();


        DB db = new DB();
        boolean flag = db.validate(login, password);

        if (!flag){
            label.setText("Неверный логин или пароль");
        } else {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
            stage.setScene(new Scene(root, 600, 800));
            stage.setTitle("Hello!");
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();

        }
    }
}
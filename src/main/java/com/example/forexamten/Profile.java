package com.example.forexamten;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Profile implements Initializable {

    public static int post;

    @FXML
    Button buttonRed;

    @FXML
    Button buttonExit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (post == 1){
            buttonRed.setVisible(true);
            buttonRed.setDisable(false);
        } else {
            buttonRed.setVisible(false);
            buttonRed.setDisable(true);
        }
    }

    @FXML
    public void exit(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage.setScene(new Scene(root, 600, 800));
        stage.setTitle("Hello!");
        stage.setResizable(false);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}

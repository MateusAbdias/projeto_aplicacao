package com.example.projeto_aplicacao;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class TelaInicialControler implements Initializable {

    @FXML
    private Button btn_login;

    public void funcaoMudarPagina(){
        ScreenManeger sm = ScreenManeger.getInstance();
        sm.changeScreen("tela_login.fxml", "Login");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}

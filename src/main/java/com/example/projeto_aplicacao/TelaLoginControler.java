package com.example.projeto_aplicacao;

import com.example.projeto_aplicacao.util.Alerts;
import com.example.projeto_aplicacao.util.EmailValidator;
import dados.RepositorioLogin;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import negocios.beans.Login;
import negocios.exceptions.LoginInvalidoException;

public class TelaLoginControler {

    @FXML
    private Hyperlink btn_cadastro;

    @FXML
    private Button btn_entrar;

    @FXML
    private TextField txt_senha;

    @FXML
    private TextField txt_usuario;

    public void funcaoMudarPagina() {
        ScreenManeger sm = ScreenManeger.getInstance();
        sm.changeScreen("tela_home.fxml", "Tela home");
    }

    public void irParaCadastro(){
        ScreenManeger sm = ScreenManeger.getInstance();
        sm.changeScreen("tela_selecione_cadastro.fxml", "Selecione o tipo de cadastro");
    }

    public void onBtnEntrar() {
        try {
            String login = txt_usuario.getText();
            String senha = txt_senha.getText();

            // Valida o e-mail
            if (!EmailValidator.isValidEmail(login)) {
                Alerts.showAlert("Erro", "E-mail inválido", "Por favor, insira um e-mail válido.", Alert.AlertType.ERROR);
                return;
            }

            String user = RepositorioLogin.getInstance().loginMatch(new Login(login, senha));

            System.out.println("Login bem sussucedido!");
            funcaoMudarPagina();
        } catch (LoginInvalidoException e) {
            Alerts.showAlert("Error", "Login invalido", e.getMessage(), Alert.AlertType.INFORMATION);
        } catch(Exception e) {
            e.printStackTrace();
            Alerts.showAlert("Erro", "Ocorreu um erro inesperado", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}

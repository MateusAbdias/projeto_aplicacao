package com.example.projeto_aplicacao;

import com.example.projeto_aplicacao.util.Alerts;
import com.example.projeto_aplicacao.util.CadastroInvalidoException;
import dados.RepositorioProfessores;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import negocios.beans.Professor;


public class TelaCadastroProfControler {


    @FXML
    private Button btnCadastrar;

    @FXML
    private Hyperlink btnVoltar;

    @FXML
    private TextField inputCPF;

    @FXML
    private TextField inputEmail;

    @FXML
    private TextField inputMateria;

    @FXML
    private TextField inputSenha;

    @FXML
    private TextField inputnome;

    public void voltar() {
        ScreenManeger sm = ScreenManeger.getInstance();
        sm.changeScreen("tela_selecione_cadastro.fxml", "Selecione o Cadastro");
    }

    public void onBtnEntrar() {
        try {
            String nome = inputnome.getText();
            String cpf = inputCPF.getText();
            String email = inputEmail.getText();
            String materia = inputMateria.getText();

            RepositorioProfessores.getInstance().add(new Professor(nome, cpf, email, materia));

            System.out.println("Cadastro do professor bem sussucedido!");

        } catch (CadastroInvalidoException e) {
            Alerts.showAlert("Error", "Cadastro invalido", e.getMessage(), Alert.AlertType.INFORMATION);
        } catch(Exception e) {
            e.printStackTrace();
            Alerts.showAlert("Erro", "Ocorreu um erro inesperado", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

}

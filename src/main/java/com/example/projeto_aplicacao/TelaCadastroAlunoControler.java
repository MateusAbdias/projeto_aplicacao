package com.example.projeto_aplicacao;

import com.example.projeto_aplicacao.util.Alerts;
import com.example.projeto_aplicacao.util.CadastroInvalidoException;
import dados.RepositorioAlunos;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import negocios.beans.Aluno;

public class TelaCadastroAlunoControler {

    @FXML
    private Button btnCadastrar;

    @FXML
    private Hyperlink btnVoltar;

    @FXML
    private TextField inputCPF;

    @FXML
    private TextField inputEmail;

    @FXML
    private Text inputMatricula;

    @FXML
    private TextField inputNome;

    @FXML
    private TextField inputSenha;

    @FXML
    private TextField inputPeriodo;

    public void voltar() {
        ScreenManeger sm = ScreenManeger.getInstance();
        sm.changeScreen("tela_selecione_cadastro.fxml", "Selecione o Cadastro");
    }

    public void onBtnEntrar() {
        try {
            String nome = inputNome.getText();
            String cpf = inputCPF.getText();
            String email = inputEmail.getText();
            String senha = inputSenha.getText();
            String matricula = inputMatricula.getText();
            int periodo = Integer.parseInt(inputPeriodo.getText());

            RepositorioAlunos.getInstance().add(new Aluno(nome, cpf, matricula, email, senha, periodo));
            System.out.println("Cadastro do aluno bem sussucedido!");

        } catch (CadastroInvalidoException e) {
            Alerts.showAlert("Error", "Cadastro invalido", e.getMessage(), Alert.AlertType.INFORMATION);
        } catch(Exception e) {
            e.printStackTrace();
            Alerts.showAlert("Erro", "Ocorreu um erro inesperado", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

}

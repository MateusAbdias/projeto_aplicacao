package com.example.projeto_aplicacao;

import com.example.projeto_aplicacao.util.Alerts;
import dados.RepositorioAlunos;
import dados.RepositorioQuestoes;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import negocios.beans.Questao;
import negocios.exceptions.CriarQuestaoException;

public class TelaCriarQuestaoControler {

    @FXML
    private Button btnSalvar;

    @FXML
    private Hyperlink btn_voltar;

    @FXML
    private TextField txt_altA;

    @FXML
    private TextField txt_altB;

    @FXML
    private TextField txt_altC;

    @FXML
    private TextField txt_altCorreta;

    @FXML
    private TextField txt_altD;

    @FXML
    private TextField txt_enunciado;

    public void voltar() {
        ScreenManeger sm = ScreenManeger.getInstance();
        sm.changeScreen("tela_questoes.fxml", "Tela Banco de Questões");
    }

    public void onBtnSalvarQuestao() {
        try {
            String enunciado = txt_enunciado.getText();
            String alternativaA = txt_altA.getText();
            String alternativaB = txt_altB.getText();
            String alternativaC = txt_altC.getText();
            String alternativaD = txt_altD.getText();
            String correta = txt_altCorreta.getText();

            RepositorioQuestoes.getInstance().add(new Questao(enunciado, alternativaA, alternativaB, alternativaC, alternativaD, correta));
            System.out.println("Cadastro feito!");
            Alerts.showAlert("Sucesso", "Cadastro de questão", "Cadastro de questão realizado com sucesso!", Alert.AlertType.CONFIRMATION);
            RepositorioAlunos.getInstance().salvarArquivo();
            voltar();


        } catch (CriarQuestaoException e) {
            Alerts.showAlert("Error", "Cadastro invalido", e.getMessage(), Alert.AlertType.INFORMATION);
        } catch(Exception e) {
            e.printStackTrace();
            Alerts.showAlert("Erro", "Ocorreu um erro inesperado", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

}

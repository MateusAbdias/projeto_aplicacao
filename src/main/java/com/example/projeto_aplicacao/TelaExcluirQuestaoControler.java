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

public class TelaExcluirQuestaoControler {

    @FXML
    private Button btn_excluir;

    @FXML
    private TextField btn_id;

    @FXML
    private Hyperlink btn_voltar;

    public void voltar() {
        ScreenManeger sm = ScreenManeger.getInstance();
        sm.changeScreen("tela_questoes.fxml", "Tela Banco de Questões");
    }

    public void onBtnExcluir() {
        try {
            int id = Integer.parseInt(btn_id.getText());
            RepositorioQuestoes.getInstance().delete(id);
            RepositorioQuestoes.getInstance().salvarArquivo();

            System.out.println("Procedimento de excluir feito!");
            Alerts.showAlert("Sucesso", "Excluir questão", "Remoção de questão realizado com sucesso!", Alert.AlertType.CONFIRMATION);
            RepositorioAlunos.getInstance().salvarArquivo();
            voltar();

        } catch(Exception e) {
            e.printStackTrace();
            Alerts.showAlert("Erro", "Ocorreu um erro inesperado", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}

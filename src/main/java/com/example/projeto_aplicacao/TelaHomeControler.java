package com.example.projeto_aplicacao;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

public class TelaHomeControler {

    @FXML
    private Button btn_ir_bancoQuestao;

    @FXML
    private Button btn_realizar_prova;

    @FXML
    private Hyperlink btn_sair;

    public void funcSair() {
        ScreenManeger sm = ScreenManeger.getInstance();
        sm.changeScreen("tela_inicial.fxml", "Star Provas");
    }

    public void funcIrQuestoes() {
        ScreenManeger sm = ScreenManeger.getInstance();
        sm.changeScreen("tela_questoes.fxml", "Banco de Dados de questões");
    }

    public void funRealizarProva() {
        ScreenManeger sm = ScreenManeger.getInstance();
        sm.changeScreen("tela_realizar_prova.fxml", "Realizar Prova");
    }

}

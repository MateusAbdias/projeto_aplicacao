package com.example.projeto_aplicacao;

import com.example.projeto_aplicacao.services.ProvaService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import negocios.beans.Questao;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TelaProvaControler {

    @FXML
    private Button btn_finalizar;

    @FXML
    private Button btn_qt1C_a;

    @FXML
    private Button btn_qt1C_b;

    @FXML
    private Button btn_qt1C_c;

    @FXML
    private Button btn_qt1C_d;

    @FXML
    private Label txt_qt1;

    @FXML
    private Label txt_qt1_alta;

    @FXML
    private Label txt_qt1_altb;

    @FXML
    private Label txt_qt1_altc;

    @FXML
    private Label txt_qt1_altd;

    @FXML
    private Label lbl_resultado;

    private ProvaService provaService;
    private List<String> respostasUsuario;

    public void initialize(URL location, ResourceBundle resources) {
        if (provaService == null) {
            provaService = new ProvaService();
        }
        respostasUsuario = new ArrayList<>();

        // Inicializa a lista de respostas com valores padrão (evitar erro de index)
        for (int i = 0; i < provaService.getQuestoes().size(); i++) {
            respostasUsuario.add(""); // Preenche com strings vazias
        }

        // Carregar as questões na tela
        initializeNodes();
    }

    private void initializeNodes() {
        List<Questao> questoes = provaService.getQuestoes();
        if (questoes.isEmpty()) {
            lbl_resultado.setText("Nenhuma questão disponível.");
            return;
        }

        Questao questao1 = questoes.get(0);

        // Exibir a questão 1 e alternativas
        txt_qt1.setText(questao1.getEnunciado());
        txt_qt1_alta.setText(questao1.getAlternativaA());
        txt_qt1_altb.setText(questao1.getAlternativaB());
        txt_qt1_altc.setText(questao1.getAlternativaC());
        txt_qt1_altd.setText(questao1.getAlternativaD());

        // Definir ações dos botões para capturar a resposta da questão 1
        btn_qt1C_a.setOnAction(e -> respostasUsuario.set(0, "A"));
        btn_qt1C_b.setOnAction(e -> respostasUsuario.set(0, "B"));
        btn_qt1C_c.setOnAction(e -> respostasUsuario.set(0, "C"));
        btn_qt1C_d.setOnAction(e -> respostasUsuario.set(0, "D"));

        // Evento de finalizar e validar a prova
        btn_finalizar.setOnAction(e -> validarProva());
    }

    private void validarProva() {
        int pontuacao = provaService.validarRespostas(respostasUsuario);

        // Exibir a pontuação
        lbl_resultado.setText("Pontuação: " + pontuacao + "/" + provaService.getQuestoes().size());
    }

    public void funcSair() {
        ScreenManeger sm = ScreenManeger.getInstance();
        sm.changeScreen("tela_inicial.fxml", "Star Provas");
    }

    public void upProva(){
        if (provaService == null){
            throw new IllegalStateException("Service está nulo");
        }
        initializeNodes();
    }
}

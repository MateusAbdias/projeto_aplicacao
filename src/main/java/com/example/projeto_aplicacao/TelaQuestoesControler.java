package com.example.projeto_aplicacao;

import com.example.projeto_aplicacao.services.QuestoesService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import negocios.beans.Questao;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TelaQuestoesControler implements Initializable {

    private QuestoesService questoesService;

    public void setQuestoesService(QuestoesService questoesService){
        this.questoesService = questoesService;
    }

    @FXML
    private TableView<Questao> tableQuestao;

    @FXML
    private TableColumn<Questao, Integer> tableColumnId;

    @FXML
    private TableColumn<Questao, String> tableColumnEnunciado;

    @FXML
    private TableColumn<Questao, String> tableColumnOpcA;

    @FXML
    private TableColumn<Questao, String> tableColumnOpcB;

    @FXML
    private TableColumn<Questao, String> tableColumnOpcC;

    @FXML
    private TableColumn<Questao, String> tableColumnOpcD;

    @FXML
    private TableColumn<Questao, String> tableColumnOpcCorreta;

    @FXML
    private Hyperlink btnVoltar;

    @FXML
    private Button btnNovaQuestao;

    @FXML
    private Button btnRemoverQuestao;

    public ObservableList<Questao> obsListQuestao;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNodes();
    }

    public void onBtnADD() {
        ScreenManeger sm = ScreenManeger.getInstance();
        sm.changeScreen("tela_criar_questao.fxml", "Star Provas");
    }

    public void onBtnRemover() {
        ScreenManeger sm = ScreenManeger.getInstance();
        sm.changeScreen("tela_excluir_questao.fxml", "Excluir Questão");
    }

    private void initializeNodes() {
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("questaoId"));
        tableColumnEnunciado.setCellValueFactory(new PropertyValueFactory<>("enunciado"));
        tableColumnOpcA.setCellValueFactory(new PropertyValueFactory<>("alternativaA"));
        tableColumnOpcB.setCellValueFactory(new PropertyValueFactory<>("alternativaB"));
        tableColumnOpcC.setCellValueFactory(new PropertyValueFactory<>("alternativaC"));
        tableColumnOpcD.setCellValueFactory(new PropertyValueFactory<>("alternativaD"));
        tableColumnOpcCorreta.setCellValueFactory(new PropertyValueFactory<>("respostaCorreta"));
    }

    public void updateTableViewQuestoes(){
        if (questoesService == null){
            throw new IllegalStateException(("Service está nulo"));
        }

        List<Questao> list = questoesService.findAll("questoes.txt");
        obsListQuestao = FXCollections.observableArrayList(list);
        tableQuestao.setItems(obsListQuestao);

    }
}

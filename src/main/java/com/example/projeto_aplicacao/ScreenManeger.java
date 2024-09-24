package com.example.projeto_aplicacao;

import com.example.projeto_aplicacao.services.QuestoesService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenManeger {

    private static ScreenManeger instance;
    private static Stage stg;

    private Scene telaLogin;
    private Scene telaInicial;
    private Scene telaQuestoes;
    private Scene telaSelecioneCadastro;
    private Scene telaCadastroProfessor;
    private Scene telaCadastroAluno;
    private Scene telaHome;
    private Scene telaProva;
    private Scene telaAddQuestao;
    private Scene telaExcluirQuestao;

    private TelaInicialControler telaIController;
    private TelaLoginControler telaLoginControler;
    private TelaQuestoesControler telaQuestoesControler;
    private TelaSelecioneCadastroController telaSelecCadastroControler;
    private TelaCadastroAlunoControler telaCadastroAlunoControler;
    private TelaCadastroProfControler telaCadastroProfControler;
    private TelaHomeControler telaHomeControler;
    private TelaProvaControler telaProvaControler;
    private TelaCriarQuestaoControler telaAddQuestaoControler;
    private TelaExcluirQuestaoControler telaExcluirQuestaoControler;

    public ScreenManeger() {
        this.screenLoader();
    }

    public static ScreenManeger getInstance() {
        if(instance == null) {
            instance = new ScreenManeger();
        }
        return instance;
    }

    public static Stage getStg() { return stg; }
    public static void setStg(Stage stg) { ScreenManeger.stg = stg; }

    public Scene getTelaInicial() { return telaInicial; }
    public Scene getTelaLogin() { return telaLogin; }
    public Scene getTelaQuestoes() { return telaQuestoes;}
    public Scene getTelaSelecioneCadastro() { return telaSelecioneCadastro; }
    public Scene getTelaCadastroProfessor() { return  telaCadastroProfessor; }
    public Scene getTelaCadastroAluno() { return  telaCadastroAluno; }
    public Scene getTelaHome() { return  telaHome; }
    public Scene getTelaProva() { return  telaProva; }
    public Scene getTelaAddQuestao() { return  telaAddQuestao; }
    public Scene getTelaExcluirQuestao() { return  telaExcluirQuestao; }

    public TelaInicialControler getTelaInicialController() { return telaIController; }
    public TelaLoginControler getTelaLoginProfessorController() { return telaLoginControler; }
    public TelaQuestoesControler getTelaQuestoesControler() { return telaQuestoesControler; }
    public TelaSelecioneCadastroController getTelaSelecioneCadastroControler() { return telaSelecCadastroControler; }
    public TelaCadastroProfControler getTelaCadastroProfControler() { return  telaCadastroProfControler; }
    public TelaCadastroAlunoControler getTelaCadastroAlunoControler() { return telaCadastroAlunoControler; }
    public TelaHomeControler getTelaHomeControler() { return telaHomeControler; }
    public TelaProvaControler getTelaProvaControler() { return telaProvaControler; }
    public TelaExcluirQuestaoControler getTelaExcluirQuestaoControler() { return telaExcluirQuestaoControler; }

    public TelaCriarQuestaoControler getTelaAddQuestaoControle() {
        return telaAddQuestaoControler;
    }

    private void screenLoader() {
        try {
            FXMLLoader telaInnit = new FXMLLoader(getClass().getResource("tela_inicial.fxml"));
            this.telaInicial = new Scene(telaInnit.load());
            this.telaIController = telaInnit.getController();

            FXMLLoader telaLogProf = new FXMLLoader(getClass().getResource("tela_login.fxml"));
            this.telaLogin = new Scene(telaLogProf.load());
            this.telaLoginControler = telaLogProf.getController();

            FXMLLoader telaSelecCadastro = new FXMLLoader(getClass().getResource("tela_selecione_cadastro.fxml"));
            this.telaSelecioneCadastro = new Scene(telaSelecCadastro.load());
            this.telaSelecCadastroControler = telaSelecCadastro.getController();

            FXMLLoader telaCadastroProf = new FXMLLoader(getClass().getResource("tela_cadastro_professor.fxml"));
            this.telaCadastroProfessor = new Scene(telaCadastroProf.load());
            this.telaCadastroProfControler = telaCadastroProf.getController();

            FXMLLoader telaCadAluno = new FXMLLoader(getClass().getResource("tela_cadastro_aluno.fxml"));
            this.telaCadastroAluno = new Scene(telaCadAluno.load());
            this.telaCadastroAlunoControler = telaCadAluno.getController();

            FXMLLoader telaHome = new FXMLLoader(getClass().getResource("tela_home.fxml"));
            this.telaHome = new Scene(telaHome.load());
            this.telaHomeControler = telaHome.getController();

            FXMLLoader telaProva = new FXMLLoader(getClass().getResource("tela_realizar_prova.fxml"));
            this.telaProva = new Scene(telaProva.load());
            this.telaProvaControler = telaProva.getController();

            FXMLLoader telaAddQuestao = new FXMLLoader(getClass().getResource("tela_criar_questao.fxml"));
            this.telaAddQuestao = new Scene(telaAddQuestao.load());
            this.telaAddQuestaoControler = telaAddQuestao.getController();

            FXMLLoader telaRemoveQuestao = new FXMLLoader(getClass().getResource("tela_excluir_questao.fxml"));
            this.telaExcluirQuestao = new Scene(telaRemoveQuestao.load());
            this.telaExcluirQuestaoControler = telaRemoveQuestao.getController();

            FXMLLoader telaQuestoesScene = new FXMLLoader(getClass().getResource("tela_questoes.fxml"));
            this.telaQuestoes = new Scene(telaQuestoesScene.load());
            this.telaQuestoesControler = telaQuestoesScene.getController();

            // Inicia e configura o serviço
            QuestoesService questoesService = new QuestoesService();
            telaQuestoesControler.setQuestoesService(questoesService);

            // Adicione uma chamada para atualizar a tabela aqui, se necessário
            telaQuestoesControler.updateTableViewQuestoes();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void changeScreen(String fileNameFxml, String titleScren) {
        boolean max = stg.isMaximized();
        if (max) stg.setMaximized(false);

        switch (fileNameFxml) {
            case "tela_inicial.fxml" -> stg.setScene(telaInicial);
            case "tela_login.fxml" -> stg.setScene(telaLogin);
            case "tela_questoes.fxml" -> stg.setScene(telaQuestoes);
            case "tela_selecione_cadastro.fxml" -> stg.setScene(telaSelecioneCadastro);
            case "tela_cadastro_professor.fxml" -> stg.setScene(telaCadastroProfessor);
            case "tela_cadastro_aluno.fxml" -> stg.setScene(telaCadastroAluno);
            case "tela_home.fxml" -> stg.setScene(telaHome);
            case "tela_realizar_prova.fxml" -> stg.setScene(telaProva);
            case "tela_criar_questao.fxml" -> stg.setScene(telaAddQuestao);
            case "tela_excluir_questao.fxml" -> stg.setScene(telaExcluirQuestao);
        }
        String titleScreen = "Star provas";
        stg.setTitle(titleScreen);

        if (max) stg.setMaximized(true);
    }


}


package com.example.projeto_aplicacao;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

public class TelaSelecioneCadastroController {

    @FXML
    private Button btn_cadastro_aluno;

    @FXML
    private Button btn_cadastro_professor;

    @FXML
    private Hyperlink btn_ir_login;

    public void funcaoMudarPagina(){
        ScreenManeger sm = ScreenManeger.getInstance();
        sm.changeScreen("tela_login.fxml", "Login");
    }

    public void irParaCadastroAluno(){
        ScreenManeger sm = ScreenManeger.getInstance();
        sm.changeScreen("tela_cadastro_aluno.fxml", "Cadastro Aluno");
    }

    public void irParaCadastroProfessor(){
        ScreenManeger sm = ScreenManeger.getInstance();
        sm.changeScreen("tela_cadastro_professor.fxml", "Cadastro Professor");
    }
}

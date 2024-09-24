package negocios.beans;

import java.io.Serializable;

public class Aluno extends Pessoa implements Serializable {

    private String matricula;
    private String senha;
    private int periodo;
    private static final long serialVersionUID = 1L;

    public Aluno(String nome, String cpf, String matricula, String email, String senha, int periodo) {
        super(nome, cpf, email);
        this.matricula = matricula;
        this.senha = senha;
        this.periodo = periodo;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getPeriodo() {
        return periodo;
    }



}

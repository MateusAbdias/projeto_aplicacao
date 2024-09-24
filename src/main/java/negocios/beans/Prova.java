package negocios.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Prova implements Serializable {

    private static int contadorId = 1000;
    private int provaId;
    private String alunoId;
    private String alunoNome;
    private List<Questao> questoes;
    private boolean finalizada;
    private List<String> respostasAluno;
    private int nota;
    private int qntQuestoes;
    private static final long serialVersionUID = 2L;

    public Prova(int provaId, Aluno aluno, int qntQuestoes) {
        this.provaId = provaId;
        this.alunoId = aluno.getMatricula();
        this.alunoNome = aluno.getNome();
        this.finalizada = false;
        this.questoes = new ArrayList<>() ;
    }

    // Getters e Setters

    public int getProvaId() {
        return provaId;
    }

    public String getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(String alunoId) {
        this.alunoId = alunoId;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public void adicionarQuestao(Questao questao) {
        this.questoes.add(questao);
    }

    public List<String> getRespostasAluno() {
        return respostasAluno;
    }

    public void setRespostasAluno(List<String> respostasAluno) {
        this.respostasAluno = respostasAluno;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }


    public int calcularNota(List<String> respostasAluno) {
        this.respostasAluno = respostasAluno;
        int nota = 0;
        for (int i = 0; i < questoes.size() && i < respostasAluno.size(); i++) {
            if (questoes.get(i).getRespostaCorreta().equalsIgnoreCase(respostasAluno.get(i))) {
                nota++;
            }
        }
        this.nota = nota;
        return nota;
    }


    public void finalizarProva() {
        this.finalizada = true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prova ID: ").append(provaId).append("\n");
        sb.append("Aluno: ").append(alunoNome).append("\n");
        sb.append("Matricula: ").append(alunoId).append("\n");
        sb.append("Questões:\n");
        for (int i = 0; i < questoes.size(); i++) {
            Questao q = questoes.get(i);
            if (q != null) {
                sb.append("Questão ").append(i + 1).append(": ").append(q.getEnunciado()).append("\n");
                sb.append("A) ").append(q.getAlternativaA()).append("\n");
                sb.append("B) ").append(q.getAlternativaB()).append("\n");
                sb.append("C) ").append(q.getAlternativaC()).append("\n");
                sb.append("D) ").append(q.getAlternativaD()).append("\n");
            } else {
                sb.append("Questão ").append(i + 1).append(": ").append("Questão nula").append("\n");
            }
        }
        return sb.toString();
    }

}

package negocios;

import dados.RepositorioQuestoes;
import negocios.beans.Questao;

public class QuestaoControle {

    RepositorioQuestoes questoes = RepositorioQuestoes.getInstance();

    public void adicionarQuestao(Questao questao) {
        questoes.add(questao);
    }

    public Questao[] listarQuestoes() {
        // System.out.println("Lista de todas as questões:");
        /*for (Questao q : questoes.getAll()) {
            System.out.println(q.getEnunciado() + " - " + q.getRespostaCorreta());
        }*/
        System.out.println(questoes.getAll()) ;
        return questoes.getAll();
    }

    public Questao buscarQuestao(String questao) {
        Questao questaoEncontrada = questoes.getOne(questao);
        System.out.println("\nQuestão encontrada pelo enunciado fornecido:");
        if (questaoEncontrada != null) {
            System.out.println(questaoEncontrada.getEnunciado());
        } else {
            System.out.println("Questão não encontrada.");
        }
        return questaoEncontrada;
    }

    public Questao buscarById(int id) {
        Questao questaoEncontrada = questoes.getById(id);
        System.out.println("\nQuestão encontrada pelo id fornecido:");
        if (questaoEncontrada != null) {
            System.out.println(questaoEncontrada.getQuestaoId() + " - " + questaoEncontrada.getEnunciado());
        } else {
            System.out.println("Questão não encontrada.");
        }
        return questaoEncontrada;
    }

    public void salvarArquivo() {
        questoes.salvarArquivo();
    }

    public void removerQuestao(int questaoId) {
        questoes.delete(questaoId);
}

//    public Questao existQuestao(int id) {
//        Boolean exist = questoes.exists(2);
//        System.out.println("Existe questão com o ID fornecido? " + (exist ? "Sim\n" : "Não\n"));
//        return null;
//    }
}
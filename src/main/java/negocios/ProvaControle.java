package negocios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import dados.RepositorioProvas;
import dados.RepositorioQuestoes;
import negocios.beans.Prova;
import negocios.beans.Questao;

public class ProvaControle {

    RepositorioProvas provas = RepositorioProvas.getInstance();

    public void adicionarProva(Prova prova, int qtQuestoes) {
        provas.add(prova);
        adicionarQuestoes(prova, qtQuestoes);
    }

    public void salvarArquivo() {
        provas.salvarArquivo();
}

    public void adicionarQuestoes(Prova prova, int quantidadeQuestoes) {
        Questao[] todasQuestoes = RepositorioQuestoes.getInstance().getAll();
        if (quantidadeQuestoes > todasQuestoes.length) {
            throw new IllegalArgumentException("Quantidade de questões solicitada excede o número disponível.");
        }

        // Converte o array para uma lista temporariamente para usar o shuffle
        List<Questao> questoesSelecionadas = new ArrayList<>(Arrays.asList(todasQuestoes));
        Collections.shuffle(questoesSelecionadas);
        questoesSelecionadas = questoesSelecionadas.subList(0, quantidadeQuestoes);
        prova.getQuestoes().addAll(questoesSelecionadas);
    }

    public Prova calcularNota(int provaId, List<String> respostasAluno) {
        Prova prova = provas.getProvaById(provaId);
        if (prova == null) {
            throw new IllegalArgumentException("Prova não encontrada.");
        }

        int nota = prova.calcularNota(respostasAluno);
        prova.setNota(nota);
        prova.finalizarProva();
        provas.salvarArquivo();
        return prova;
    }


    public Prova getProvaById(int id) {
        try {
            Prova provaRecuperada = provas.getProvaById(id);
            System.out.println("Prova recuperada: " + provaRecuperada);
        } catch (Exception e) {
            System.out.println("Erro ao recuperar a prova: " + e.getMessage());
        }
        return null;
    }

    public Prova[] listarProvas() {
        Prova[] todasProvas = provas.getAll();
        System.out.println("Lista de todas as provas:");
        for (Prova p : todasProvas) {
            System.out.println(p);
        }
        return todasProvas;
    }

   /* public Prova existeProva(int id) {
        Boolean exist = provas.exists(id);
        System.out.println("Existe questão com o ID fornecido? " + (exist ? "Sim\n" : "Não\n"));
        return null;
    }*/
}

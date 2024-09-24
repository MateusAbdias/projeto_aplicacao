package com.example.projeto_aplicacao.services;

import negocios.beans.Questao;

import java.util.List;

public class ProvaService {

    private final QuestoesService questoesService;
    private List<Questao> questoes;

    // Construtor
    public ProvaService() {
        this.questoesService = new QuestoesService();
        this.questoes = questoesService.findAll("questoes.txt");
    }

    // Método para obter as questões
    public List<Questao> getQuestoes() {
        return questoes;
    }

    // Método para validar respostas
    public int validarRespostas(List<String> respostasUsuario) {
        int pontuacao = 0;

        // Validar cada resposta
        for (int i = 0; i < questoes.size(); i++) {
            Questao questao = questoes.get(i);
            String respostaCorreta = questao.getRespostaCorreta();
            String respostaUsuario = respostasUsuario.get(i);

            // Se a resposta do usuário for igual à correta, aumenta a pontuação
            if (respostaUsuario.equalsIgnoreCase(respostaCorreta)) {
                pontuacao++;
            }
        }

        return pontuacao;
    }
}

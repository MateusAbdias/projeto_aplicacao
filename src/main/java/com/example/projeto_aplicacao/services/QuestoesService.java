package com.example.projeto_aplicacao.services;

import negocios.Fachada;
import negocios.beans.Questao;

import java.util.ArrayList;
import java.util.List;

public class QuestoesService {

    public List<Questao> findAll( String filePath) {
        Questao[] arrayQuestoes = Fachada.getInstance().listarQuestoes();

        for (int i = 0 ; i< 10 ; i++){
            System.out.println(arrayQuestoes[i]);
        }

        List<Questao> list = new ArrayList<>();
        if (arrayQuestoes != null) {

            for (Questao questao : arrayQuestoes) {
                //System.out.println(questao);
                list.add(questao);
            }
        }
        System.out.println(arrayQuestoes);
        return list;
    }
}

package com.example.projeto_aplicacao;

import dados.*;
import negocios.Fachada;
import negocios.beans.*;
import negocios.exceptions.CpfInvalidoException;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws CpfInvalidoException {

        Questao questao1 = new Questao("Qual a capital da França?", "Berlim", "Londres", "Paris", "Roma", "C");
        Questao questao2 = new Questao("Qual o maior planeta do sistema solar?", "Marte", "Júpiter", "Saturno", "Urano",
                "B");
        Questao questao3 = new Questao("Quem descobriu o Brasil?", "Pedro Álvares Cabral", "Cristóvão Colombo",
                "Vasco da Gama", "Fernando de Noronha", "A");
        Questao questao4 = new Questao("Qual é o menor país do mundo?", "Vaticano", "Mônaco", "Malta", "San Marino",
                "A");
        Questao questao5 = new Questao("Qual o elemento químico com o símbolo 'O'?", "Ouro", "Oxigênio", "Osmium",
                "Prata", "B");

        Fachada.getInstance().adicionarQuestao(questao1);
        Fachada.getInstance().adicionarQuestao(questao2);
        Fachada.getInstance().adicionarQuestao(questao3);
        Fachada.getInstance().adicionarQuestao(questao4);
        Fachada.getInstance().adicionarQuestao(questao5);
        Fachada.getInstance().salvarArquivoQuestao();
        Fachada.getInstance().listarQuestoes();

        for (int i=0; i<=10; i++){
            if (RepositorioQuestoes.getInstance().getAll()[i] != null)
                System.out.println(RepositorioQuestoes.getInstance().getAll()[i].getEnunciado());
        }

        System.out.println("");

        Fachada.getInstance().removerQuestao(5);
        Fachada.getInstance().salvarArquivoQuestao();
        Fachada.getInstance().listarQuestoes();
        for (int i=0; i<=10; i++){
            if (RepositorioQuestoes.getInstance().getAll()[i] != null)
                System.out.println(RepositorioQuestoes.getInstance().getAll()[i].getEnunciado());
        }

        Aluno aluno1 = new Aluno("Leticia", "123", "541", "leticia@", "123", 2);
        Aluno aluno2 = new Aluno("Joao", "123", "541", "leticia@", "123", 2);

        Fachada.getInstance().adicionarAluno(aluno1);
        Fachada.getInstance().adicionarAluno(aluno2);
        Fachada.getInstance().salvarArquivoAluno();
        Fachada.getInstance().listarAlunos();
        for (int i=0; i<=2; i++){
            if (RepositorioAlunos.getInstance().getAll()[i] != null)
                System.out.println("Aluno: " +RepositorioAlunos.getInstance().getAll()[i].getNome());
}

        Professor professor1 = new Professor("Paulo", "1234", "paulo@ufrpe", "IP");
        RepositorioProfessores.getInstance().add(professor1);
        System.out.println(professor1.getNome());
        RepositorioProfessores.getInstance().salvarArquivo();
        RepositorioProfessores.getInstance().getAll();

        Prova prova1 = new Prova(3, aluno1, 1);
        Prova prova2 = new Prova(7, aluno2, 2);


        Fachada.getInstance().adicionarProva(prova1, 2);
        Fachada.getInstance().salvarArquivoQuestao();
//        Fachada.getInstance().adicionarProva(prova2, 4);
        RepositorioProvas.getInstance().add(prova1);
        Fachada.getInstance().salvarArquivoProva();
//        Fachada.getInstance().listarProvas();
        System.out.println(prova1);
        for (int i =0; i<= 2; i++){
            if (RepositorioProvas.getInstance().getAll()[i] != null)
                System.out.println(RepositorioAlunos.getInstance().getAll()[i]);
        }

        /*//

        try {
            Professor prof1 = new Professor("Mateus", "123", "Mateus@gmail.com", "Geografia", "123");
            Fachada.getInstance().adicionarProfessor(prof1);
        } catch (CpfInvalidoException e) {
            System.out.println(e.getMessage()); }


        // getAll
        Fachada.getInstance().listarProfessores();

        // getOne
        Fachada.getInstance().buscarProfessor("99388678911");

        // findByName
        Fachada.getInstance().buscarProfessorPeloNome("Mateus");

        // exists
        boolean existePr = repositorioProf.exists("88388678900");
        System.out.println("\nExiste professor com o cpf fornecido? " + (existePr ? "Sim" : "Não"));

        // delete
        repositorioProf.delete("88388678900");


*//*    RepositorioProvas repositorioProvas = RepositorioProvas.getInstance();
        Prova prova1 = new Prova(3, aluno1, null);
        Prova prova2 = new Prova(7, aluno2, null);
        Prova prova3 = new Prova(55, aluno3, null);*//*

       *//* Fachada.getInstance().adicionarProva(prova1, 2);
        Fachada.getInstance().adicionarProva(prova2, 1);
        Fachada.getInstance().adicionarProva(prova3, 4);*//*

        // getProvaById
        Fachada.getInstance().getProvaById(1001);

        // getAll
        Fachada.getInstance().listarProvas();

        // remove
        //repositorioProvas.delete(55);

        //exists
        Fachada.getInstance().existeProva(55);

        // testando repositorio provas

        RepositorioLogin repositorioLogin = RepositorioLogin.getInstance();
        Login login1 = new Login("leticia@example.com", "123.456.789-00");
        Login login2 = new Login("mateus@example.com", "987.654.321-00");

        Fachada.getInstance().addLogin(login1);
        Fachada.getInstance().addLogin(login2);

        // getAll
        Fachada.getInstance().listarLogins();

        // getOne
        Fachada.getInstance().buscarLogin(1);

        //getByEmail
        Fachada.getInstance().buscarLoginPeloEmail("mateus@example.com");

        //exists
        Fachada.getInstance().existLogin(1);

        //delete
        Fachada.getInstance().deleteLogin(1);

        // testando logica da prova
        Aluno aluno = new Aluno("Letícia", "12345678900","20231001","leticia@example.com", "123", 5);

        Prova prova = new Prova(2, aluno);

        Fachada.getInstance().adicionarProva(prova, 3);
        System.out.println(prova);

        List<String> respostasAluno = Arrays.asList("C", "B", "A");

        Fachada.getInstance().calcularNota(prova.getProvaId(), respostasAluno);

        //NotaProva notaProva = new NotaProva();
        //notaProva.calcularNota(prova.getProvaId(), respostasAluno);

        System.out.println("Prova finalizada. Nota do aluno: " + prova.getNota());
        System.out.println("Status da prova (finalizada): " + prova.isFinalizada());*/
    }
}


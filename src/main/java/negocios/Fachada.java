package negocios;

import java.util.List;

import negocios.beans.Aluno;
import negocios.beans.Login;
import negocios.beans.Professor;
import negocios.beans.Prova;
import negocios.beans.Questao;
import negocios.exceptions.CpfInvalidoException;

public class Fachada {

    public void salvarArquivoQuestao() {
        questaocontrole.salvarArquivo();
    }

    public void salvarArquivoAluno() {
        alunocontrole.salvarArquivo();
    }
    public void salvarArquivoProva() {
        provacontrole.salvarArquivo();

    }

    public void removerQuestao(int questaoId) {
        questaocontrole.removerQuestao(questaoId);
}

    private ProvaControle provacontrole = new ProvaControle();
    private ProfessorControle professorcontrole = new ProfessorControle();
    private AlunoControle alunocontrole = new AlunoControle();
    private QuestaoControle questaocontrole = new QuestaoControle();
    private LoginControle logincontrole = new LoginControle();
    private static Fachada instance;

    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    public void adicionarProva(Prova prova, int qtQuestoes) {
        provacontrole.adicionarProva(prova, qtQuestoes);
    }

    public void adicionarQuestoes(Prova prova, int quantidadeQuestoes) {
        provacontrole.adicionarQuestoes(prova, quantidadeQuestoes);
    }

    public Prova getProvaById(int id) {
        return provacontrole.getProvaById(id);
    }

    public Prova[] listarProvas() {
        return provacontrole.listarProvas();
    }

    /*public Prova existeProva(int id) {
        return provacontrole.existeProva(id);
    }*/

    public void adicionarProfessor(Professor professor) throws CpfInvalidoException {
        professorcontrole.adicionarProfessor(professor);
    }

    public Professor[] listarProfessores() {
        return professorcontrole.listarProfessores();
    }

    public Professor buscarProfessor(String cpf) throws CpfInvalidoException {
        return professorcontrole.buscarProfessor(cpf);
    }

    public Professor[] buscarProfessorPeloNome(String nome) {
        return professorcontrole.buscarProfessorPeloNome(nome);
    }


    public void adicionarAluno(Aluno aluno) {
        alunocontrole.adicionarAluno(aluno);
    }

    public Aluno[] listarAlunos() {
        return alunocontrole.listarAlunos();
    }

    public Aluno buscarAluno(String matricula) {
        return alunocontrole.buscarAluno(matricula);
    }

 /*   public Aluno[] buscarAlunoPeloNome(String matricula) {
        return alunocontrole.buscarAluno( matricula);
    }*/

    public Aluno existAluno(String matricula) {
        return alunocontrole.existAluno(matricula);
    }

    public Prova calcularNota(int provaId, List<String> respostasAluno) {
        return provacontrole.calcularNota(provaId, respostasAluno);

    }

    public void adicionarQuestao(Questao questao) {
        questaocontrole.adicionarQuestao(questao);
    }

    public Questao[] listarQuestoes() {
        return questaocontrole.listarQuestoes();
    }

    public Questao buscarQuestao(String questao) {
        return questaocontrole.buscarQuestao(questao);
    }

    public Questao buscarById(int id) {
        return questaocontrole.buscarById(id);

    }

  /*  public Questao existQuestao(int id) {
        return questaocontrole.existQuestao(id);
    }*/

    public void addLogin(Login login) {
        logincontrole.addLogin(login);
    }

    public Login[] listarLogins() {
        return logincontrole.listarLogins();
    }

    public Login buscarLogin(int codigo) {
        return logincontrole.buscarLogin(codigo);
    }

    public Login buscarLoginPeloEmail(String email) {
        return logincontrole.buscarLoginPeloEmail(email);
    }

    public Login existLogin(int codigo) {
        return logincontrole.existLogin(codigo);
    }

    public void deleteLogin(int codigo) {
        logincontrole.deleteLogin(codigo);
    }


}
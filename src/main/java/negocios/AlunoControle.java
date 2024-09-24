package negocios;

import dados.RepositorioAlunos;
import negocios.beans.Aluno;

public class AlunoControle {

    RepositorioAlunos alunos = RepositorioAlunos.getInstance();

    public Aluno[] listarAlunos() {
        return alunos.getAll();
    }

    public Aluno buscarAluno(String matricula) {
        Aluno alunoEncontrado = alunos.getOne(matricula);
        System.out.println("\nAluno encontrado pela matrícula fornecida:");
        if (alunoEncontrado != null) {
            System.out.println(alunoEncontrado.getNome());
        } else {
            System.out.println("Aluno não encontrado.");
        }
        return alunoEncontrado;
    }

    /*public Aluno[] buscarAlunoPeloNome(String nome) {
        Aluno[] alunosComNome = alunos.findByName(nome);
        System.out.println("\nAlunos encontrados com o nome fornecido:");
        if (alunosComNome != null) {
            for (Aluno a : alunosComNome) {
                System.out.println(a.getNome() + " - " + a.getMatricula());
            }
        } else {
            System.out.println("Nenhum aluno encontrado com esse nome.");
        }
        return alunosComNome;
    }*/

    public Aluno existAluno(String matricula) {
        boolean existeAl = alunos.exists(matricula);
        System.out.println("\nExiste aluno com a matrícula fornecida? " + (existeAl ? "Sim" : "Não"));
        return null;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.cadastrar(aluno);
    }

    public void salvarArquivo() {
        alunos.salvarArquivo();
}


}


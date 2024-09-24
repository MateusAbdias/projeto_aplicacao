package negocios;

import dados.RepositorioProfessores;
import negocios.beans.Professor;
import negocios.exceptions.CpfInvalidoException;

public class ProfessorControle {

    RepositorioProfessores professores = RepositorioProfessores.getInstance();

    private void validarCpf(String cpf) throws CpfInvalidoException {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d+")) {
            throw new CpfInvalidoException("CPF inválido! O CPF deve conter 11 dígitos numéricos.");
        }
    }


    public void adicionarProfessor(Professor professor) throws CpfInvalidoException
    {     	validarCpf(professor.getCpf());
        professores.add(professor);
    }


    public Professor[] listarProfessores() {
        System.out.println("\nLista de todos os professores:");
        for (Professor a : professores.getAll()) {
            System.out.println(a.getNome() + " - " + a.getCpf());
        }
        return null;
    }

    public Professor buscarProfessor(String cpf) throws CpfInvalidoException {
        validarCpf(cpf);
        Professor professorEncontrado = professores.getOne(cpf); System.out.println("\nProfessor encontrado pelo cpf fornecido:");
        if (professorEncontrado != null) {    System.out.println(professorEncontrado.getNome());
        } else {
            System.out.println("Professor não encontrado.");
        }
        return professorEncontrado;
    }


    public Professor[] buscarProfessorPeloNome(String nome) {
        Professor[] professoresComNome = professores.findByName(nome);
        System.out.println("\nprofessores encontrados com o nome fornecido:");
        if (professoresComNome != null) {
            for (Professor a : professoresComNome) {
                System.out.println(a.getNome() + " - " + a.getCpf());
            }
        } else {
            System.out.println("Nenhum professor encontrado com esse nome.");
        }
        return professoresComNome;
    }
}

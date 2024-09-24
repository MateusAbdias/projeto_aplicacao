package dados.load;

import dados.RepositorioProfessores;
import negocios.beans.Professor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadProfessores {

    public static RepositorioProfessores carregarProfessores() {
        RepositorioProfessores repositorio = new RepositorioProfessores(10);

        String path = "src/arquivos/professores.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                String nome = line;
                String cpf = br.readLine();
                String email = br.readLine();
                String materia = br.readLine();

                if (nome != null && cpf != null && email != null && materia != null ) {
                    Professor professor = new Professor(nome, cpf, email, materia);
                    repositorio.add(professor);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo de professores: " + e.getMessage());
        }

        return repositorio;
    }
}

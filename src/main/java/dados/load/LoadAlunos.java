package dados.load;

import dados.RepositorioAlunos;
import negocios.beans.Aluno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadAlunos {

    public static RepositorioAlunos carregarAlunos() {
        RepositorioAlunos repositorio = new RepositorioAlunos(10); // Inicializa o repositório com a capacidade desejada

        String path = "src/arquivos/alunos.txt"; // O caminho do arquivo que contém os dados dos alunos

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                String nome = line;
                String cpf = br.readLine();
                String matricula = br.readLine();
                String email = br.readLine();
                String senha = br.readLine();
                String periodoStr = br.readLine();

                if (nome != null && cpf != null && matricula != null && email != null && senha != null && periodoStr != null) {
                    int periodo = Integer.parseInt(periodoStr);
                    Aluno aluno = new Aluno(nome, cpf, matricula, email, senha, periodo);
                    repositorio.add(aluno);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo de alunos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter o período: " + e.getMessage());
        }

        return repositorio;
    }
}


package dados.load;

import negocios.beans.Questao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadQuestoes {

    public List<Questao> carregarQuestoes(String arquivo) {
        List<Questao> questoes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(","); // Supondo que os dados estejam separados por vírgula
                if (partes.length == 6) {
                    Questao questao = new Questao(partes[0], partes[1], partes[2], partes[3], partes[4], partes[5]);
                    questoes.add(questao);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return questoes;
    }

}

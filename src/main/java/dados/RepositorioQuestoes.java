package dados;

import java.io.*;

import negocios.beans.Questao;

public class RepositorioQuestoes implements Serializable {

    private static RepositorioQuestoes instance;
    private Questao[] questoes;
    private int proxima;
    private int quantidadeQuestoes;
    private final String path = "src/main/java/arquivos/questoes.txt";
    private static final long serialVersionUID = 1L;

    private RepositorioQuestoes(int tamanho) {
        this.questoes = new Questao[tamanho];
        this.proxima = 0;
        quantidadeQuestoes = 0;
    }

    public static RepositorioQuestoes getInstance() {
        if (instance == null) {
            instance = lerDoArquivo();
        }
        return instance;
    }

    public void add(Questao questao) {

        questoes[proxima++] = questao;
        quantidadeQuestoes++;

        salvarArquivo();
    }

    public Questao[] getAll() {
//        System.out.println(lerDoArquivo().questoes[0]);
        return lerDoArquivo().questoes;
    }

    public Questao getOne(String enunciado) {
        for (int i = 0; i < quantidadeQuestoes; i++) {
            if (questoes[i] != null && enunciado.equals(questoes[i].getEnunciado())) {
                return questoes[i];
            }
        }
        return null;
    }

    public Questao getById(int id) {
        for (int i = 0; i < quantidadeQuestoes; i++) {
            if (questoes[i].getQuestaoId() == id) {
                return questoes[i];
            }
        }
        return null;
    }

    public static RepositorioQuestoes lerDoArquivo() {
        RepositorioQuestoes instanciaLocal = null;

        File in = new File("questoes.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioQuestoes) o;
        } catch (Exception e) {
            instanciaLocal = new RepositorioQuestoes(100);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {/* Silent exception */
                }
            }
            return instanciaLocal;
        }
    }

    public void salvarArquivo() {
        if (instance == null) {
            return;
        }
        File out = new File("questoes.txt");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    /* Silent */
                }
            }
        }
    }

    public void cadastrar(Questao q) {
        this.questoes[this.proxima] = q;
        this.proxima = this.proxima + 1;
    }

    public void cadastrar() {
        Questao q = new Questao("teste 'O'?", "sd", "sdfsd", "dfs", "sdff", "D");
        this.cadastrar(q);
        if (this.proxima == this.questoes.length) {
            this.duplicaArrayQuestoes();
        }
    }

    private void duplicaArrayQuestoes() {
        if (this.questoes != null && this.questoes.length > 0) {
            Questao[] arrayDuplicado = new Questao[this.questoes.length * 2];
            for (int i = 0; i < this.questoes.length; i++) {
                arrayDuplicado[i] = this.questoes[i];
            }
            this.questoes = arrayDuplicado;
        }
    }
    public void delete(int questaoId) {
        for (int i = 0; i < proxima; i++) {
            if (questaoId == questoes[i].getQuestaoId()) {
                System.arraycopy(questoes, i + 1, questoes, i, proxima - i - 1);
                questoes[--proxima] = null;
                salvarArquivo();
                return;
            }
        }
    }

}



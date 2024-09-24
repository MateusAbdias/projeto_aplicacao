package dados;

import java.io.*;

import negocios.beans.Prova;
import negocios.exceptions.ProvaNaoEncontradaException;

public class RepositorioProvas implements Serializable {

    RepositorioAlunos repositorioAlunos = RepositorioAlunos.getInstance();
    private static RepositorioProvas instance;
    private Prova[] provas;
    private int proxima;
    int quantidadeProvas;
    private final String path = "src/main/java/arquivos/prova.txt";
    private static final long serialVersionUID = 2L;

    private RepositorioProvas(int tamanho) {
        this.provas = new Prova[tamanho];
        this.proxima = 0;
    }

    public static RepositorioProvas getInstance() {
        if (instance == null) {
            instance = lerDoArquivo();
        }
        return instance;
    }

    public void add(Prova prova) {
        provas[proxima++] = prova;

        quantidadeProvas++;
        salvarArquivo();
    }

    public Prova[] getAll() {
        Prova[] provasPreenchidas = new Prova[proxima];
        System.arraycopy(provas, 0, provasPreenchidas, 0, proxima);
        return lerDoArquivo().provas;
    }


    public Prova[] getProvasByAluno(String alunoId) {
        Prova[] resultadoTemp = new Prova[proxima];
        int count = 0;
        for (int i = 0; i < proxima; i++) {
            if (alunoId.equals(provas[i].getAlunoId())) {
                resultadoTemp[count++] = provas[i];
            }
        }
        Prova[] resultado = new Prova[count];
        System.arraycopy(resultadoTemp, 0, resultado, 0, count);
        return resultado;
    }


    public Prova getProvaById(int id) throws ProvaNaoEncontradaException{
        for (int i = 0; i < proxima; i++) {
            if (provas[i].getProvaId() == id) {
                return provas[i];
            }
        }
        throw new ProvaNaoEncontradaException("Prova com ID " + id + " não foi encontrada.");
    }



    /*public void delete(int provaId) {
        for (int i = 0; i < proxima; i++) {
            if (provaId ==(provas[i].getProvaId())) {
                System.arraycopy(provas, i + 1, provas, i, proxima - i - 1);
                provas[--proxima] = null;
                updateWriter(provas[i]);
                return;
            }
        }
    }


    public void updateWriter(Prova prova) {
        // conferindo pq tava iniciando com o objeto prova nulo. Evitar nullpointexception
        if (prova == null) {
            System.err.println("Erro: Prova é null. Não é possível atualizar o arquivo.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write("Prova ID: " + prova.getProvaId());
            bw.newLine();
            bw.write("Aluno: " + prova.getAlunoId());
            bw.newLine();
            bw.write("Nota: " + prova.getNota());
            bw.newLine();
            bw.write("Finalizada: " + prova.isFinalizada());
            bw.newLine();
            bw.write("-------------------------");
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao atualizar o arquivo de provas: " + e.getMessage());
        }
    }
 */

    private static RepositorioProvas lerDoArquivo() {
        RepositorioProvas instanciaLocal = null;

        File in = new File("provas.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioProvas) o;
        } catch (Exception e) {
            instanciaLocal = new RepositorioProvas(100);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {/* Silent exception */
                }
            }
        }

        return instanciaLocal;
    }

    public void salvarArquivo() {
        if (instance == null) {
            return;
        }
        File out = new File("provas.txt");
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


    /*public boolean exists(int provaId) {
        for (int i = 0; i < proxima; i++) {
            if (provaId == provas[i].getProvaId()) {
                return true;
            }
        }
        return false;
    }
    */
}
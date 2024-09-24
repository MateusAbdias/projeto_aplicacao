package dados;

import java.io.*;
import java.util.Arrays;

import negocios.beans.Professor;

public class RepositorioProfessores implements Serializable {

    private static RepositorioProfessores instance;
    private int quantidadeProfessores;
    private int proxima;
    private Professor[] professores;
    private final String path = "professores.txt";
    private static final long serialVersionUID = -5L;

    public RepositorioProfessores(int tamanho) {
        this.professores = new Professor[tamanho];
        this.proxima = 0;
        quantidadeProfessores = 0;
    }

    public static RepositorioProfessores getInstance() {
        if (instance == null) {
            instance = lerDoArquivo();
        }
        return instance;
    }

    public void add(Professor professor) {
        professores[proxima++] = professor;
        quantidadeProfessores++;
        salvarArquivo();
    }

    public Professor[] getAll() {
        return lerDoArquivo().professores;
    }

    public Professor getOne(String cpf) {
        for (int i = 0; i < quantidadeProfessores; i++) {
            if (professores[i] != null && cpf.equals(professores[i].getCpf())) {
                return professores[i];
            }
        }
        return null;
    }

    public Professor[] findByName(String nome) {
        Professor[] encontrados = new Professor[quantidadeProfessores];
        int contador = 0;

        for (int i = 0; i < quantidadeProfessores; i++) {
            if (professores[i] != null && nome.equalsIgnoreCase(professores[i].getNome())) {
                encontrados[contador] = professores[i];
                contador++;
            }
        }
        return contador > 0 ? Arrays.copyOf(encontrados, contador) : null;
    }

    public void salvarArquivo() {
        if (instance == null) {
            return;
        }
        File out = new File("professor.txt");
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

    public static RepositorioProfessores lerDoArquivo() {
        RepositorioProfessores instanciaLocal = null;
        File in = new File("professores.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioProfessores) o;
        } catch (Exception e) {
            instanciaLocal = new RepositorioProfessores(100);
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
    /*public void delete(String cpf) {
        for (int i = 0; i < quantidadeProfessores; i++) {
            if (professores[i] != null && cpf.equals(professores[i].getCpf())) {
                professores[i] = null;
            }
        }
        updateWriter();
    }

    public void updateWriter() {
        String path = "src/main/java/arquivos/professores.txt";
        String[] txt = new String[150];
        int linhaAtual = 0;

        for (int i = 0; i < quantidadeProfessores; i++) {
            if (professores[i] != null) {
                txt[linhaAtual] = professores[i].getNome();
                txt[linhaAtual + 1] = professores[i].getCpf();
                linhaAtual += 2;
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String linha : txt) {
                if (linha != null) {
                    bw.write(linha);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean exists(String cpf) {
        for (int i = 0; i < quantidadeProfessores; i++) {
            if (professores[i] != null && cpf.equals(professores[i].getCpf())) {
                return true;
            }
        }
        return false;*/

}
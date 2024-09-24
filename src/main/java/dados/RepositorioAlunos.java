package dados;

import java.io.*;

import negocios.beans.Aluno;

public class RepositorioAlunos implements Serializable {

    private static RepositorioAlunos instance;
    private int proxima;
    private int quantidadeAlunos;
    private Aluno[] alunos;
    private  String path = "src/main/java/arquivos/alunos.txt";
    private static final long serialVersionUID = -1L;

    public RepositorioAlunos(int tamanho) {
        this.alunos = new Aluno[tamanho];
        alunos = new Aluno[tamanho];
        quantidadeAlunos = 0;
    }

    public static RepositorioAlunos getInstance() {
        if (instance == null) {
            instance = lerDoArquivo();
        }
        return instance;
    }

    public void add(Aluno aluno) {

        alunos[proxima++] = aluno;
        quantidadeAlunos++;

        salvarArquivo();
    }

    public Aluno[] getAll() {
        /*if (instance != null && instance.alunos[0] != null) {
            System.out.println(instance.alunos[0]);
        }*/
        return instance.alunos;
    }


    public Aluno getOne(String nome) {
        for (int i = 0; i < quantidadeAlunos; i++) {
            if (alunos[i] != null && nome.equals(alunos[i].getNome())) {
                return alunos[i];
            }
        }
        return null;
    }

    public Aluno getById(String id) {
        for (int i = 0; i < quantidadeAlunos; i++) {
            if (alunos[i].getMatricula() == id) {
                return alunos[i];
            }
        }
        return null;
    }

    public static RepositorioAlunos lerDoArquivo() {
        RepositorioAlunos instanciaLocal = null;
        File in = new File("alunos.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioAlunos) o;
        } catch (Exception e) {
            instanciaLocal = new RepositorioAlunos(100);
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
        File out = new File("alunos.txt");
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

    public void cadastrar(Aluno a) {
        this.alunos[this.proxima] = a;
        this.proxima = this.proxima + 1;
    }

    public void cadastrar() {
        Aluno a = new Aluno("teste 'O'?", "sd", "sdfsd", "dfs", "sdff", 1);
        this.cadastrar(a);
        if (this.proxima == this.alunos.length) {
            this.duplicaArrayAlunos();
        }
    }

    private void duplicaArrayAlunos() {
        if (this.alunos != null && this.alunos.length > 0) {
            Aluno[] arrayDuplicado = new Aluno[this.alunos.length * 2];
            for (int i = 0; i < this.alunos.length; i++) {
                arrayDuplicado[i] = this.alunos[i];
            }
            this.alunos = arrayDuplicado;
        }
    }

    public boolean exists(String matricula) {
        for (int i = 0; i < quantidadeAlunos; i++) {
            if (alunos[i] != null && matricula.equals(alunos[i].getMatricula())) {
                return true;
            }
        }
        return false;
    }

}

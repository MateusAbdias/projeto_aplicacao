package dados;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import dados.load.LoadLogin;
import negocios.beans.Login;

public class RepositorioLogin {

    private static RepositorioLogin instance;
    private int quantidadeLogins;
    private Login logins[];
    private final String path = "arquivos/login.txt";

    public RepositorioLogin(int numeroMaximo) {
        logins = new Login[numeroMaximo];
        quantidadeLogins = 0;
        //limparArquivo();
    }

    public static RepositorioLogin getInstance() {
        if (instance == null) {
            instance = LoadLogin.cadastrarLogins();
        }
        return instance;
    }

    public Login[] getAll() {
        return Arrays.copyOf(logins, quantidadeLogins);
    }

    private void limparArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
        } catch (IOException e) {
            System.err.println("Erro ao limpar o arquivo: " + e.getMessage());
        }
    }

    public Login getOne(int codigo) {
        for (int i = 0; i < logins.length; i++) {
            if (logins[i] != null && codigo == logins[i].getCodigo()) {
                return logins[i];
            }
        }
        return null;
    }

    public String loginMatch(Login login) {
        for (int i = 0; i < quantidadeLogins; i++) {
            if (logins[i] != null && login.equals(logins[i])) {
                return logins[i].getEmail();
            }
        }
        throw new RuntimeException("Email ou CPF incorretos. Tente novamente.");
    }

    public Login findByEmail(String email) {
        for (int i = 0; i < quantidadeLogins; i++) {
            if (logins[i] != null && email.equals(logins[i].getEmail())) {
                return logins[i];
            }
        }
        return null;
    }

    public void add(Login login) {
        if (quantidadeLogins < logins.length) {
            logins[quantidadeLogins] = login;
            quantidadeLogins++;
        }
        updateWriter();
    }

    public void delete(int codigo) {
        for (int i = 0; i < logins.length; i++) {
            if (logins[i] != null && codigo == logins[i].getCodigo()) {
                logins[i] = null;
            }
        }
        updateWriter();
    }

    public void updateWriter() {
        String path = "src/main/java/arquivos/login.txt";
        String txt[] = new String[150];

        int numeroLinha = 0;

        for (int j = 0; j < logins.length; j++) {
            if (logins[j] != null) {
                txt[numeroLinha] = logins[j].getEmail();
                txt[numeroLinha + 1] = logins[j].getCpf();
                numeroLinha = numeroLinha + 2;
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < txt.length - 1; i++) {
                if (txt[i] != null) {
                    bw.write(txt[i]);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean exists(int codigo) {
        for (int i = 0; i < logins.length; i++) {
            if (logins[i] != null && codigo == logins[i].getCodigo()) {
                return true;
            }
        }
        return false;
    }

}

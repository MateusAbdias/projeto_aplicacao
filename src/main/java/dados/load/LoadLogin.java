package dados.load;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import dados.RepositorioLogin;
import negocios.beans.Login;

public class LoadLogin {

    public static RepositorioLogin cadastrarLogins() {
        RepositorioLogin repositorio = new RepositorioLogin(10);

        String path = "arquivos/login.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                String email = line;
                line = br.readLine();
                if (line != null) {
                    String cpf = line;
                    repositorio.add(new Login(email, cpf));
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo de logins: " + e.getMessage());
        }

        return repositorio;
    }

}

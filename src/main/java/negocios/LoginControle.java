package negocios;

import dados.RepositorioLogin;
import negocios.beans.Login;

public class LoginControle {
    RepositorioLogin logins = RepositorioLogin.getInstance();


    public void addLogin(Login login) {
        logins.add(login);
    }

    public Login[] listarLogins() {
        System.out.println("Lista de logins:");
        for (Login login : logins.getAll()) {
            System.out.println(login);
        }
        return null;
    }

    public Login buscarLogin(int codigo) {
        System.out.println("\nBuscando login pelo código:");
        Login foundLogin = logins.getOne(codigo);
        if (foundLogin != null) {
            System.out.println("Login encontrado: " + foundLogin.getEmail());
        } else {
            System.out.println("Login não encontrado.");
        }
        return foundLogin;
    }

    public Login buscarLoginPeloEmail(String email) {
        System.out.println("\nBuscando login pelo email");
        Login foundByEmail = logins.findByEmail(email);
        if (foundByEmail != null) {
            System.out.println("Login encontrado: " + foundByEmail.getEmail());
        } else {
            System.out.println("Login não encontrado.");
        }
        return foundByEmail;
    }

    public Login existLogin(int codigo) {
        boolean exists = logins.exists(codigo);
        System.out.println("\nExiste login com o código fornecido? " + (exists ? "Sim" : "Não"));
        return null;
    }

    public void deleteLogin(int codigo) {
        logins.delete(codigo);
        Login deletedLogin = logins.getOne(codigo);
        if (deletedLogin == null) {
            System.out.println("\nLogin removido com sucesso.");
        } else {
            System.out.println("\nErro ao remover login.");
        }
        return;
    }
}

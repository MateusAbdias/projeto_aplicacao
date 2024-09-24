package negocios.beans;

import java.io.Serializable;
import java.util.Objects;

public class Login implements Serializable {

    private static final long serialVersionUID = 885653720265630290L;
    private int codigo;
    private String email; // O email será o nome de usuário
    private String cpf; // O CPF será a senha
    private static int contadorCodigo = 0;

    public Login(String email, String cpf) {
        this.email = email;
        this.cpf = cpf;
        this.codigo = gerarNovoCodigo();
    }

    private int gerarNovoCodigo() {
        return ++contadorCodigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login1 = (Login) o;
        return Objects.equals(email, login1.email) && Objects.equals(cpf, login1.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, cpf);
    }

    @Override
    public String toString() {
        return "Email: " + email + '\n' +
                "CPF: " + cpf + '\n';
    }

}

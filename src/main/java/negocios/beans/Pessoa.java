package negocios.beans;

public class Pessoa {

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private boolean estadoLogado;

    public Pessoa(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public boolean getEstadoLogado() {
        return estadoLogado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEstadoLogado(boolean estadoLogado) {
        this.estadoLogado = estadoLogado;
    }
}
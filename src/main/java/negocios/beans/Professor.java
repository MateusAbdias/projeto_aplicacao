package negocios.beans;

import java.io.Serializable;

public class Professor extends Pessoa implements Serializable {
    private String materia;
    private static final long serialVersionUID = -5L;

    public Professor(String nome, String cpf, String email, String materia) {
        super(nome, cpf, email);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

}

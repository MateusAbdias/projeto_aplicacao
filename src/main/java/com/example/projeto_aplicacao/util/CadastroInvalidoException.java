package com.example.projeto_aplicacao.util;

public class CadastroInvalidoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CadastroInvalidoException(String msg){
        super(msg);
    }
}

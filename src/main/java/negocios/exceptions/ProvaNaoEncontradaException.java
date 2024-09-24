package negocios.exceptions;

public class ProvaNaoEncontradaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ProvaNaoEncontradaException(String msg){
        super(msg);
    }
}
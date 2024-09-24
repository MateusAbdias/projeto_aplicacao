package negocios.exceptions;

public class LoginInvalidoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LoginInvalidoException(String msg){
        super(msg);
    }
}
package server.api.exception;

public class NoEntityFoundException extends IllegalStateException {

    public NoEntityFoundException() {
        super("No entity found");
    }

    public NoEntityFoundException(String msg) {
        super(msg);
    }
}

package server.api.exception;

public class IllegalAction extends IllegalStateException {

    public IllegalAction() {
        super("Illegal action");
    }

    public IllegalAction(String msg) {
        super(msg);
    }
}

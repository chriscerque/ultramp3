package net.ent.etrs.ultramp3.view.exceptions;

public class ViewException extends Exception {
    public ViewException() {
    }

    public ViewException(String message) {
        super(message);
    }

    public ViewException(String message, Throwable cause) {
        super(message, cause);
    }

    public ViewException(Throwable cause) {
        super(cause);
    }

    public ViewException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

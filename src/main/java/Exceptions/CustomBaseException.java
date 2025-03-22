package Exceptions;

public abstract class CustomBaseException extends Exception{

    protected CustomBaseException(String message) {
        super(message);
    }

    //protected CustomBaseException(String message, Throwable cause) {
    //    super(message, cause);
    //}
}


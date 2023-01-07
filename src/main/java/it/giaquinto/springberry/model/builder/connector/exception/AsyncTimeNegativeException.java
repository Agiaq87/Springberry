package it.giaquinto.springberry.model.builder.connector.exception;

public class AsyncTimeNegativeException extends Exception{

    public AsyncTimeNegativeException() {
    }

    public AsyncTimeNegativeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Async timeout can not be negative";
    }
}

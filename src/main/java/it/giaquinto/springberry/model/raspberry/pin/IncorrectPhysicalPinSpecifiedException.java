package it.giaquinto.springberry.model.raspberry.pin;

public class IncorrectPhysicalPinSpecifiedException extends Exception{

    public IncorrectPhysicalPinSpecifiedException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

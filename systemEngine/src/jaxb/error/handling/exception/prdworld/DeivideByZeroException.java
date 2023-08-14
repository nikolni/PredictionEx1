package jaxb.error.handling.exception.prdworld;

public class DeivideByZeroException extends RuntimeException{
    private final String EXCEPTION_MESSAGE = "You cant divide by zero";

    @Override
    public String getMessage() {
        return EXCEPTION_MESSAGE;
    }
}

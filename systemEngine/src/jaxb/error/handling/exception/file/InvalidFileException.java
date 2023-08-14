package jaxb.error.handling.exception.file;


public class InvalidFileException extends RuntimeException{
    private final String EXCEPTION_MESSAGE = "File path is not provided";

    @Override
    public String getMessage() {
        return EXCEPTION_MESSAGE;
    }
}

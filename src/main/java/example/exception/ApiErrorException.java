package example.exception;

public class ApiErrorException extends Exception {

    public ApiErrorException(String message) {
        super(message);
    }
}

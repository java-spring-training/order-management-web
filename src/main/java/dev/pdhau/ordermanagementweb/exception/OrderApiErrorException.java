package dev.pdhau.ordermanagementweb.exception;

public class OrderApiErrorException extends Exception {

    private static final long serialVersionUID = 1L;

    public OrderApiErrorException(String message) {
        super(message);
    }
}

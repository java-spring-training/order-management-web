package web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import web.exception.ApiException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiErrorHandler {

    private Logger log = Logger.getLogger(ApiErrorHandler.class);

    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleHttpRequestMethodNotSupportedException(
            ApiException ex) {
        return "order";
    }
}

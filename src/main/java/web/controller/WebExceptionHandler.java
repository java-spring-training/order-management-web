package web.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import web.exception.CustomerApiErrorException;
import web.exception.ParameterInvalidException;

@ControllerAdvice
public class WebExceptionHandler {

    private Logger log = Logger.getLogger(WebExceptionHandler.class);

    @ExceptionHandler(ParameterInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleParameterInvalidException(final ParameterInvalidException ex, final Model model) {

        log.error("Invalid Input parameter", ex);
        model.addAttribute("message", "Invalid Input parameter");
        return "add-customer";
    }

    @ExceptionHandler(CustomerApiErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleCustomerApiErrorException(final CustomerApiErrorException ex, final Model model) {

        log.error("Customer api return error", ex);
        model.addAttribute("message", "Customer api return error");
        return "error";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUnknownException(final Exception ex, final Model model) {

        log.error("INTERNAL SERVER ERROR", ex);
        model.addAttribute("message", "INTERNAL SERVER ERROR");
        return "error";
    }
}

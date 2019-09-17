package order.controller;

import order.exception.OrderApiErrorException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WebExceptionHandler {

    private Logger log = Logger.getLogger(WebExceptionHandler.class);
    @ExceptionHandler(OrderApiErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleProductApiErrorException(OrderApiErrorException ex, Model model) {

        log.error("Order Api return Error", ex);

        model.addAttribute("message", "Order Api return Error");
        return "error";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUnknownException(Exception ex, Model model) {

        log.error("INTERNAL SERVER ERROR", ex);

        model.addAttribute("message", "INTERNAL SERVER ERROR");
        return "error";
    }

}

package dev.pdhau.ordermanagementweb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import dev.pdhau.ordermanagementweb.exception.OrderApiErrorException;

@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(OrderApiErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleProductApiErrorException(OrderApiErrorException ex, Model model) {

        model.addAttribute("message", "Product Api return Error");
        return "error";
    }
}

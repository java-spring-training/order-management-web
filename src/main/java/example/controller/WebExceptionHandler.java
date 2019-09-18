package example.controller;

import example.exception.ParameterInvalidException;
import example.exception.ApiErrorException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WebExceptionHandler {

    private Logger log = Logger.getLogger(WebExceptionHandler.class);

    @ExceptionHandler(ParameterInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleParameterInvalidException(ParameterInvalidException ex, Model model) {

        log.error("Invalid Input parameter", ex);

        model.addAttribute("message", "Invalid Input parameter");
        return "error";
    }

    /**
     *
     * ProductApiErrorException là exception chung khi gọi api "localhost:8080/list"
     * dù cho api có định nghĩa nhiều lỗi: 400 403 404 500 ...
     * thì trên màn hình cũng chỉ cần define 1 ProductApiErrorException để mô tả việc gọi api bị fail
     *
     * khi 1 ứng dụng web gọi đến nhiều api thì quy định mỗi 1 api sẽ tạo 1 exception tương ứng
     * đây là quy định trong workshop này thôi
     * trên thực tế muốn tạo bao nhiêu exception thì tùy thuộc vào cách tổ chức source của từng team
     *
     */
    @ExceptionHandler(ApiErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleProductApiErrorException(ApiErrorException ex, Model model) {

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

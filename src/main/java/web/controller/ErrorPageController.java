package web.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ErrorPageController implements ErrorController {


    @RequestMapping("/error")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String HandlerErrorNotFoundUrl() {
        return "order";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}

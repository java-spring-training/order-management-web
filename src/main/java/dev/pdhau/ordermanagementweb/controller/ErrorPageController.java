package dev.pdhau.ordermanagementweb.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController implements ErrorController {


    @RequestMapping("/404")
    public String handlerErrorNotFoundUrl(Model model) {
        model.addAttribute("message", "Page not found");

        return "error";
    }

    @RequestMapping("/500")
    public String handlerErrorSystem(Model model) {

        model.addAttribute("message", "System error");
        return "error";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}

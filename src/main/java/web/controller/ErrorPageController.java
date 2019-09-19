package web.controller;

import org.apache.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.configuration.WebPathConfig;

@Controller
public class ErrorPageController implements ErrorController {

    private Logger log = Logger.getLogger(ErrorPageController.class);

    @RequestMapping(WebPathConfig.PAGE_NOT_FOUND_URL)
    public String handlerErrorNotFoundUrl(Model model) {

        log.error("Invalid Url");
        model.addAttribute("message", "PAGE NOT FOUND @.@");
        return "error";
    }

    @RequestMapping(WebPathConfig.INTERNAL_SERVER_ERROR_PAGE_URL)
    public String handlerErrorSystem(Model model) {

        log.error("Internal error");
        model.addAttribute("message", "WEBSITE IS NOT WORKING @.@");
        return "error";
    }

    @Override
    public String getErrorPath() {

        return "/error";
    }
}

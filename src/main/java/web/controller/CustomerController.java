package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.configuration.WebPathConfig;
import web.exception.CustomerApiErrorException;
import web.service.CustomerService;

import javax.validation.Valid;

@Controller
public class CustomerController {

    private CustomerService customerService;
    private CustomerRequestFactory factory;

    @Autowired
    public CustomerController(final CustomerService customerService, final CustomerRequestFactory factory) {

        this.customerService = customerService;
        this.factory = factory;
    }

    @GetMapping(WebPathConfig.ADD_CUSTOMER_PAGE)
    public String showAddCustomerPage(CustomerRequestBody customerRequestBody) {

        return "index";
    }

    @PostMapping(WebPathConfig.ADD_CUSTOMER_POST_URL)
    public String addCustomer(final @Valid CustomerRequestBody customerRequestBody, final BindingResult bindingResult,
                final RedirectAttributes redirectAttributes) throws CustomerApiErrorException {

        if (bindingResult.hasErrors()) {
            return "index";
        }
        customerService.addCustomer(factory.toCustomers(customerRequestBody));
        redirectAttributes.addFlashAttribute("message", "Add customer successfully!");
        return "redirect:/customer/add";
    }
}

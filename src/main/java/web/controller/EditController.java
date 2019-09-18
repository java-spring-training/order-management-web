package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.config.ApiConfig;
import web.domain.entities.object.Order;
import web.exception.ApiException;
import web.repository.OrderRequest;
import web.service.OrderService;

import javax.validation.Valid;

@Controller
public class EditController {
    private OrderFactory factory;
    private OrderService orderService;
    @Autowired
    public EditController (OrderFactory factory, OrderService orderService) {
        this.factory = factory;
        this.orderService = orderService;
    }
    @GetMapping(ApiConfig.EDIT_ORDER)
    public String editOrder(OrderRequestBody orderRequestBody) throws Exception {
        return "order";
    }

    @PostMapping (ApiConfig.EDIT_ORDER)
    public String postEditOrder(@Valid OrderRequestBody orderRequestBody, BindingResult bindingResult,
                                RedirectAttributes attributes) throws ApiException {
        if(bindingResult.hasErrors()) {
            return "order";
        }
        final Order orderData = factory.toOrder(orderRequestBody);
        final OrderRequest orderRequest = factory.toOrderRequest(orderData);
        orderService.editOrder(orderRequest);
        attributes.addFlashAttribute("message", "success");
        return "index";
    }

    private String getErrorMessage(BindingResult bindingResult) {

        // Create message from BindingResult
        // Ex: 'name': must not be empty
        StringBuilder message = new StringBuilder();
        bindingResult.getFieldErrors().forEach(fieldError -> message
                .append("'")
                .append(fieldError.getField())
                .append("'")
                .append(": ")
                .append(fieldError.getDefaultMessage())
                .append(", "));
        return message.toString();
    }
}

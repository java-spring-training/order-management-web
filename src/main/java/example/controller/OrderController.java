package example.controller;

import example.configuration.WebPathConfig;
import example.domain.entities.object.OrderDetail;
import example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(WebPathConfig.LIST_ORDER_BY_CUSTOMER)
    public String list(Model model, CustomerForm customerForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception {

        List<OrderDetail> orderList = orderService.getOrdersByCustomer(customerForm.getCustomerNumber());
        model.addAttribute("orderList", orderList);
        model.addAttribute("orderForm", customerForm);

        return "order";
    }

    @PostMapping(WebPathConfig.LIST_ORDER_BY_CUSTOMER)
    public String listOrderByCustomer(Model model, @ModelAttribute CustomerForm customerForm, RedirectAttributes redirectAttributes, BindingResult bindingResult) throws Exception {

        List<OrderDetail> orderList = orderService.getOrdersByCustomer(customerForm.getCustomerNumber());
        model.addAttribute("orderList", orderList);
        model.addAttribute("orderForm", customerForm);

        return "redirect:/orders/"+customerForm.getCustomerNumber();
    }
}

package dev.pdhau.ordermanagementweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.pdhau.ordermanagementweb.exception.OrderApiErrorException;
import dev.pdhau.ordermanagementweb.request.OrderDetailRequest;
import dev.pdhau.ordermanagementweb.request.OrderRequest;
import dev.pdhau.ordermanagementweb.service.OrderService;

@Controller
@RequestMapping(path = "/order/add")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String doGet(Model model) {
        OrderRequest orderRequest = new OrderRequest();
        for (int i = 1; i <= 2; i++) {
            orderRequest.addOrderDetails(new OrderDetailRequest());
        }
        model.addAttribute("form", orderRequest);
        return "order/add";
    }

    @PostMapping
    public String doPost(@ModelAttribute OrderRequest orderRequest, Model model, RedirectAttributes redirectAttributes)
            throws OrderApiErrorException {
        if(!orderService.add(orderRequest)) {
            redirectAttributes.addFlashAttribute("message", "Error occurs!");
            return "redirect:/order/add";
        }
        redirectAttributes.addFlashAttribute("message", "Order created!");
        return "redirect:/order/add";
    }
}

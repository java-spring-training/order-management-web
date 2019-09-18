package order.management.web.controller;

import order.management.web.configuration.WebPathConfig;
import order.management.web.domain.entities.object.Order;
import order.management.web.domain.value.object.OrderNumber;
import order.management.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class OrderController {

    private OrderService service;
    private OrderModelFactory factory;

    @Autowired
    public OrderController(OrderService service, OrderModelFactory factory) {

        this.service = service;
        this.factory = factory;
    }

    @GetMapping(WebPathConfig.LIST_ORDER_PAGE)
    public String filterOrderList(@ModelAttribute OrderFilterForm orderFilterForm, Model model) throws Exception {

        Integer orderNumber = orderFilterForm.getOrderNumber();

        if (orderNumber != null) {

            OrderNumber orderNumber1 = new OrderNumber(orderNumber);
            List<Order> orders = service.getOrdersByOrderNumber(orderNumber1);
            List<OrderModel> orderModelList = factory.toOrderModelList(orders);
            model.addAttribute("orders", orderModelList);
        }

        return "orders";

    }
}

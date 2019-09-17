package order.controller;

import order.configuration.WebPathConfig;
import order.domain.entities.object.Order;
import order.domain.entities.object.OrderDetail;
import order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    private OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping(WebPathConfig.LIST_ORDER_PAGE)
    public String listAllOrder(Model model) throws Exception {

        List<Order> orders = service.getAll();
        List<Map<String, String>> data = new ArrayList<>();
        for(Order order: orders) {
            for(OrderDetail orderDetail: order.getOrderDetailList()) {
                Map<String, String> item = new HashMap<>();
                item.put("orderNumber", order.getOrderNumber().value().toString());
                item.put("orderDate", order.getOrderDate().toString());
                item.put("status", order.getStatus());
                item.put("productName", orderDetail.getProduct().getProductName());
                item.put("buyPrice", orderDetail.getProduct().getBuyPrice().toString());
                item.put("customerName", order.getCustomer().getCustomerName());
                item.put("phone", order.getCustomer().getPhone());
                item.put("country", order.getCustomer().getCountry());
                item.put("employeeEmail", order.getCustomer().getEmployee().getEmail());
                data.add(item);
            }
        }

        model.addAttribute("orders", data);

        return "orders";

    }
}

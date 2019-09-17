package order.management.web.controller;

import order.management.web.domain.entities.object.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderModelFactory {

    public List<OrderModel> toOrderModelList(List<Order> orders) {
        return orders.stream().map(this::toOrderModel).collect(Collectors.toList());
    }

    public OrderModel toOrderModel(Order order) {

        int orderNumber = order.getOrderNumber().getNumber();
        Date orderDate = order.getOrderDate();
        String status = order.getStatus();
        String productName = order.getOrderDetail().getProduct().getProductName();
        BigDecimal buyPrice = order.getOrderDetail().getPriceEach();
        String customerName = order.getCustomer().getCustomerName();
        String phone = order.getCustomer().getPhone();
        String country = order.getCustomer().getCountry();
        String employeeEmail = order.getCustomer().getSalesRepEmployee().getEmail();

        return new OrderModel(orderNumber, orderDate, status, productName, buyPrice, customerName, phone, country,
                employeeEmail);
    }
}

package order.management.web.repository;

import order.management.web.domain.entities.object.*;
import order.management.web.domain.value.object.OrderNumber;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderFactory {

    public List<Order> toOrders(List<OrderResult> orderResults) {

        return orderResults.stream().map(this::toOrder).collect(Collectors.toList());
    }

    private Order toOrder(OrderResult orderResult) {

        OrderNumber orderNumber = new OrderNumber(orderResult.getOrderNumber());
        Date orderDate = orderResult.getOrderDate();
        String status = orderResult.getStatus();

        Product product = new Product(orderResult.getProductName());
        OrderDetail orderDetail = new OrderDetail(orderNumber, orderResult.getBuyPrice(), product);

        Employee salesRepEmployee = new Employee(orderResult.getEmployeeEmail());
        Customer customer = new Customer(orderResult.getCustomerName(), orderResult.getPhone(),
                orderResult.getCountry(), salesRepEmployee);

        Order order = new Order(orderNumber, orderDate, status, orderDetail, customer);

        return order;
    }
}

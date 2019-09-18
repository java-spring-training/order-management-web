package example.repository;

import example.domain.entities.object.*;
import example.domain.entities.object.Product;
import example.domain.value.object.OrderNumber;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderFactory {
    private Order toOrder(OrderResult orderResult) {
        OrderNumber orderNumber = new OrderNumber(orderResult.getOrderNumber());
        Customer customer = new Customer(null, orderResult.getCustomerName(), orderResult.getPhone(), orderResult.getCountry(), new Employee(orderResult.getEmployeeEmail()));

        return new Order(orderNumber, orderResult.getOrderDate(), orderResult.getStatus(), customer);
    }

    public List<Order> toOrderList(List<OrderResult> orderModelList) {
        return orderModelList.stream().map(this::toOrder).collect(Collectors.toList());
    }

    private OrderDetail toOrderDetail(OrderResult orderResult) {
        OrderNumber orderNumber = new OrderNumber(orderResult.getOrderNumber());
        Customer customer = new Customer(null, orderResult.getCustomerName(), orderResult.getPhone(), orderResult.getCountry(), new Employee(orderResult.getEmployeeEmail()));

        Order order = new Order(orderNumber, orderResult.getOrderDate(), orderResult.getStatus(), customer);
        List<Product> productList = orderResult.getProducts();

        return new OrderDetail(order, productList);
    }

    public List<OrderDetail> toOrderDetailList(List<OrderResult> orderResults) {
        return orderResults.stream().map(this::toOrderDetail).collect(Collectors.toList());
    }
}

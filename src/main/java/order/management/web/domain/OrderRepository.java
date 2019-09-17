package order.management.web.domain;

import order.management.web.domain.entities.object.Order;
import order.management.web.domain.value.object.OrderNumber;
import order.management.web.exception.OrderApiErrorException;

import java.util.List;

public interface OrderRepository {
    List<Order> getOrdersByOrderNumber(OrderNumber orderNumber) throws OrderApiErrorException;
}

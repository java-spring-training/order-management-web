package order.domain;

import order.domain.entities.object.Order;
import order.exception.OrderApiErrorException;

import java.util.List;

public interface OrderRepository {

    List<Order> getAll() throws OrderApiErrorException;
}

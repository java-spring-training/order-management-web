package order.management.web.service;

import order.management.web.domain.OrderRepository;
import order.management.web.domain.entities.object.Order;
import order.management.web.domain.value.object.OrderNumber;
import order.management.web.exception.OrderApiErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> getOrdersByOrderNumber(OrderNumber orderNumber) throws OrderApiErrorException {

        return repository.getOrdersByOrderNumber(orderNumber);
    }
}

package order.service;

import order.domain.OrderRepository;
import order.domain.entities.object.Order;
import order.exception.OrderApiErrorException;
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

    public List<Order> getAll() throws OrderApiErrorException {

        return repository.getAll();
    }
}

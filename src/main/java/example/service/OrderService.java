package example.service;

import example.domain.OrderRepository;
import example.domain.entities.object.OrderDetail;
import example.exception.ApiErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDetail> getOrdersByCustomer(int customerNumber) throws ApiErrorException {
        return orderRepository.getListOrderByCustomerNumber(customerNumber);
    }
}

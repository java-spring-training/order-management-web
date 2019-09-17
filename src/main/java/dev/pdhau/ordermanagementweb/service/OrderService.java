package dev.pdhau.ordermanagementweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.pdhau.ordermanagementweb.domain.OrderRepository;
import dev.pdhau.ordermanagementweb.exception.OrderApiErrorException;
import dev.pdhau.ordermanagementweb.request.OrderRequest;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public boolean add(OrderRequest order) throws OrderApiErrorException {

        return orderRepository.add(order.toDomainEntity());
    }
}

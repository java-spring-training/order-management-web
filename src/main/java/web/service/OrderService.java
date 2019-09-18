package web.service;

import org.springframework.web.client.HttpStatusCodeException;
import web.domain.OrderRepository;
import web.domain.entities.object.Order;
import web.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.repository.OrderRequest;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void editOrder(OrderRequest orderRequest) throws ApiException {
        try {
            orderRepository.editOrder(orderRequest);
        } catch (HttpStatusCodeException ex) {
            throw new ApiException("API ERROR!!!");
        }
    }
}

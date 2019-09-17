package order.repository;

import order.configuration.ApiPathConfig;
import order.domain.OrderRepository;
import order.domain.entities.object.Order;
import order.exception.OrderApiErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private ApiPathConfig apiPathConfig;
    private OrderFactory orderFactory;

    @Autowired
    public OrderRepositoryImpl(ApiPathConfig apiPathConfig, OrderFactory orderFactory) {
        this.apiPathConfig = apiPathConfig;
        this.orderFactory = orderFactory;
    }

    @Override
    public List<Order> getAll() throws OrderApiErrorException {

        RestTemplate restTemplate = new RestTemplate();

        String apiUrl = UriComponentsBuilder
                .fromHttpUrl(apiPathConfig.getHost())
                .port(apiPathConfig.getPort())
                .path(apiPathConfig.getName())
                .build().encode().toString();

        try {

            ResponseEntity<OrderResponse> response = restTemplate.getForEntity(apiUrl, OrderResponse.class);

            if (response.getBody() == null || response.getStatusCodeValue() != HttpStatus.OK.value()) {
                throw new OrderApiErrorException("Call API Error");
            }

            return orderFactory.toListOrder(response.getBody().getResults());

        } catch (HttpStatusCodeException ex) {

            throw new OrderApiErrorException("Call API Error");
        }

    }
}


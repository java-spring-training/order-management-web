package order.management.web.repository;

import order.management.web.configuration.ApiPathConfig;
import order.management.web.domain.OrderRepository;
import order.management.web.domain.entities.object.Order;
import order.management.web.domain.value.object.OrderNumber;
import order.management.web.exception.OrderApiErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
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
    public List<Order> getOrdersByOrderNumber(OrderNumber orderNumber) throws OrderApiErrorException {

        RestTemplate restTemplate = new RestTemplate();

        String apiUrl = UriComponentsBuilder.fromHttpUrl(apiPathConfig.getHost()).port(apiPathConfig.getPort())
                .path(apiPathConfig.getName()).queryParam("orderNumber", orderNumber.getNumber()).build().encode().toString();

        try {
            ResponseEntity<OrderResponse> response = restTemplate.getForEntity(apiUrl, OrderResponse.class);

            // Gọi api thành công nhưng response không có data hoặc HttpStatus != 200
            if (response.getBody() == null || response.getStatusCodeValue() != HttpStatus.OK.value()) {
                throw new OrderApiErrorException("Call API Error");
            }

            // factory thành domain và gửi về service
            return orderFactory.toOrders(response.getBody().getResults());

        } catch (Exception ex) {

            // Xảy ra lỗi khi call api
            System.out.println(ex.getMessage());
            throw new OrderApiErrorException("Call API Error");
        }

    }
}

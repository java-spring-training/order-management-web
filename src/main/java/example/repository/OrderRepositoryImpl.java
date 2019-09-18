package example.repository;

import example.configuration.ApiPathConfig;
import example.domain.OrderRepository;
import example.domain.entities.object.OrderDetail;
import example.exception.ApiErrorException;
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
    public List<OrderDetail> getListOrderByCustomerNumber(int customerNumber) throws ApiErrorException {
        RestTemplate restTemplate = new RestTemplate();

        String apiUrl = UriComponentsBuilder
                .fromHttpUrl(apiPathConfig.getHost())
                .port(apiPathConfig.getPort())
                .path(apiPathConfig.getName())
                .queryParam("customerNumber", customerNumber)
                .build().encode().toString();

        try {
            ResponseEntity<OrderResponse> response = restTemplate.getForEntity(apiUrl, OrderResponse.class);

            List<OrderDetail> results = orderFactory.toOrderDetailList(response.getBody().getResults());

            // Gọi api thành công nhưng response không có data hoặc HttpStatus != 200
            if (response.getBody() == null || response.getStatusCodeValue() != HttpStatus.OK.value()) {
                throw new ApiErrorException("Call API Error");
            }

            return results;

        } catch (HttpStatusCodeException ex) {

            // Xảy ra lỗi khi call api
            throw new ApiErrorException("Call API Error");
        }
    }
}

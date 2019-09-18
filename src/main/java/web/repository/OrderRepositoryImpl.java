package web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import web.config.ApiConfig;
import web.domain.OrderRepository;
import web.domain.entities.object.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private ApiConfig apiConfig;
    public OrderRepositoryImpl (ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
    }
    @Override
    public void editOrder (OrderRequest orderRequest) {
        final String apiUrl = UriComponentsBuilder
                .fromHttpUrl(apiConfig.getHost())
                .port(apiConfig.getPort())
                .path(apiConfig.getName())
                .build().encode().toString();
        final RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<OrderRequest> requestBody = new HttpEntity<>(orderRequest);
        restTemplate.postForEntity(apiUrl, requestBody, String.class);
    }
}

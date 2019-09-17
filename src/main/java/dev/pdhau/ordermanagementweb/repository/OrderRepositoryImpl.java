package dev.pdhau.ordermanagementweb.repository;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import dev.pdhau.ordermanagementweb.domain.OrderRepository;
import dev.pdhau.ordermanagementweb.domain.entities.object.Order;
import dev.pdhau.ordermanagementweb.exception.OrderApiErrorException;
import dev.pdhau.ordermanagementweb.response.ApiAddOrderResponse;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public boolean add(Order order) throws OrderApiErrorException {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        String url = "http://localhost:9090/api/v1/order/add";
        HttpEntity<Order> requestEntity = new HttpEntity<>(headers);
        try {
            ResponseEntity<ApiAddOrderResponse> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, ApiAddOrderResponse.class);
            if (response.getBody() == null || response.getStatusCodeValue() != HttpStatus.OK.value()) {
                throw new OrderApiErrorException("Call API Error");
            }
            return "success".equals(response.getBody().getCode());
        } catch (HttpStatusCodeException ex) {
            throw new OrderApiErrorException("Call API Error");
        }
    }
}

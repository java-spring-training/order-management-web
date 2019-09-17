package web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import web.configuration.ApiPathConfig;
import web.domain.CustomerRepository;
import web.domain.entities.object.Customers;
import web.exception.CustomerApiErrorException;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private ApiPathConfig apiPathConfig;

    @Autowired
    public CustomerRepositoryImpl(final ApiPathConfig apiPathConfig) {

        this.apiPathConfig = apiPathConfig;
    }

    @Override
    public void addCustomer(final Customers customers) throws CustomerApiErrorException {

        try {
            final String apiUrl = UriComponentsBuilder
                    .fromHttpUrl(apiPathConfig.getHost())
                    .port(apiPathConfig.getPort())
                    .path(apiPathConfig.getName())
                    .build().encode().toString();

            final RestTemplate restTemplate = new RestTemplate();
            final HttpEntity<Customers> requestBody = new HttpEntity<>(customers);
            restTemplate.postForEntity(apiUrl, requestBody, String.class);
        } catch (HttpStatusCodeException ex) {
            throw new CustomerApiErrorException(String.format("Call api error. ex=[%s]", ex.getMessage()));
        }
    }
}

package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.domain.CustomerRepository;
import web.domain.entities.object.Customers;
import web.exception.CustomerApiErrorException;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(final CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public void addCustomer(final Customers customers) throws CustomerApiErrorException {

        customerRepository.addCustomer(customers);
    }
}

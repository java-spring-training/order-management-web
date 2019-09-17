package web.domain;

import web.domain.entities.object.Customers;
import web.exception.CustomerApiErrorException;

public interface CustomerRepository {

    void addCustomer(Customers customers) throws CustomerApiErrorException;
}

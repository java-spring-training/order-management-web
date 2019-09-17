package web.controller;

import org.springframework.stereotype.Component;
import web.domain.entities.object.Customers;

@Component
public class CustomerRequestFactory {

    public Customers toCustomers(CustomerRequestBody requestBody) {

        return new Customers(requestBody.getCustomerNumber(), requestBody.getCustomerName(),
                requestBody.getContactLastName(), requestBody.getContactFirstName(), requestBody.getPhone(),
                requestBody.getAddressLine1(), requestBody.getAddressLine2(), requestBody.getCity(),
                requestBody.getState(), requestBody.getPostalCode(), requestBody.getCountry(),
                requestBody.getSalesRepEmployeeNumber(), requestBody.getCreditLimit());
    }
}

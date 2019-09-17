package order.domain.entities.object;

import order.domain.value.object.CustomerNumber;

public class Customer
{
    private CustomerNumber customerNumber;
    private String customerName;
    private String phone;
    private String city;
    private String country;
    private Employee employee;

    public Customer(CustomerNumber customerNumber, String customerName, String phone, String city, String country, Employee employee) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.phone = phone;
        this.city = city;
        this.country = country;
        this.employee = employee;
    }

    public CustomerNumber getCustomerNumber() {
        return customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Employee getEmployee() {
        return employee;
    }
}

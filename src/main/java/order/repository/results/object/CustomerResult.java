package order.repository.results.object;

import com.fasterxml.jackson.annotation.JsonGetter;

public class CustomerResult {
    private int customerNumber;
    private String customerName;
    private String phone;
    private String city;
    private String country;
    private EmployeeResult employeeResult;

    public CustomerResult() {

    }

    public CustomerResult(int customerNumber, String customerName, String phone, String city, String country, EmployeeResult employeeResult) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.phone = phone;
        this.city = city;
        this.country = country;
        this.employeeResult = employeeResult;
    }

    public int getCustomerNumber() {
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

    public EmployeeResult getEmployeeResult() {
        return employeeResult;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmployeeResult(EmployeeResult employeeResult) {
        this.employeeResult = employeeResult;
    }
}
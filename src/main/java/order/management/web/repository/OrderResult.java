package order.management.web.repository;

import java.math.BigDecimal;
import java.util.Date;

public class OrderResult {

    private Integer orderNumber;
    private Date orderDate;
    private String status;
    private String productName;
    private BigDecimal buyPrice;
    private String customerName;
    private String phone;
    private String country;
    private String employeeEmail;

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

}

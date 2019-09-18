package web.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class OrderRequestBody {
    public OrderRequestBody () {

    }
    @NotNull
    @Min(value = 0, message="Min = 0")
    private Integer customerNumber;
    @NotNull
    @Min(value = 0, message="Min = 0")
    private Integer orderId;
    @NotNull
    private String productCode;
    @NotNull
    @Pattern(regexp="^\\d{4}-\\d{2}-\\d{2}$", message="date format must be 0000-00-00")
    private String orderDate;
    @NotNull
    @Pattern(regexp="^\\d{4}-\\d{2}-\\d{2}$", message="date format must be 0000-00-00")
    private String requiredDate;
    @Pattern(regexp="^(\\d{4}-\\d{2}-\\d{2}|.{0})$", message="date format must be 0000-00-00")
    private String shippedDate;
    @NotNull
    private String status;
    private String comments;
    @Min(value = 0)
    private Integer quanlityOrdered;
    @Min(value = 0)
    private Integer priceEach;
    @Min(value = 0)
    private Integer orderLineNumber;

    public OrderRequestBody(Integer customerNumber, Integer orderId, String productCode, String orderDate, String requiredDate, String shippedDate, String status, String comments, Integer quanlityOrdered, Integer priceEach, Integer orderLineNumber) {
        this.customerNumber = customerNumber;
        this.orderId = orderId;
        this.productCode = productCode;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.quanlityOrdered = quanlityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(String requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Integer getQuanlityOrdered() {
        return quanlityOrdered;
    }

    public void setQuanlityOrdered(Integer quanlityOrdered) {
        this.quanlityOrdered = quanlityOrdered;
    }

    public Integer getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(Integer priceEach) {
        this.priceEach = priceEach;
    }

    public Integer getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(Integer orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}

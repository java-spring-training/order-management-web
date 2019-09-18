package order.management.web.domain.entities.object;

import order.management.web.domain.value.object.OrderNumber;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Order
 */
public class Order {

    @NotNull
    private OrderNumber orderNumber;

    @NotNull
    @DateTimeFormat
    private Date orderDate;

    @NotEmpty
    private String status;

    private OrderDetail orderDetail;
    private Customer customer;

    public Order(@NotNull OrderNumber orderNumber, @NotNull Date orderDate, @NotEmpty String status, OrderDetail orderDetail, Customer customer) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.status = status;
        this.orderDetail = orderDetail;
        this.customer = customer;
    }

    public OrderNumber getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(OrderNumber orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
package order.domain.entities.object;

import order.domain.value.object.OrderNumber;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private OrderNumber orderNumber;
    private Date orderDate;
    private String status;
    private Customer customer;
    private List<OrderDetail> orderDetailList;

    public Order(OrderNumber orderNumber, Date orderDate, String status, Customer customer) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.status = status;
        this.customer = customer;
        this.orderDetailList = new ArrayList<OrderDetail>();
    }

    public OrderNumber getOrderNumber() {
        return orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}

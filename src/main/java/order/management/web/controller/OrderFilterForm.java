package order.management.web.controller;

public class OrderFilterForm {

    private Integer orderNumber;

    public OrderFilterForm(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
}

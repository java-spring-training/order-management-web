package order.management.web.domain.entities.object;

import order.management.web.domain.value.object.OrderNumber;

import java.math.BigDecimal;

/**
 * OrderDetail
 */
public class OrderDetail {

    private OrderNumber orderNumber;

    private BigDecimal priceEach;

    private Product product;

    public OrderDetail(OrderNumber orderNumber,
                       BigDecimal priceEach, Product product) {
        this.orderNumber = orderNumber;
        this.priceEach = priceEach;
        this.product = product;
    }

    public OrderNumber getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(OrderNumber orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
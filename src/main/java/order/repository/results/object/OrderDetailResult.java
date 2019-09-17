package order.repository.results.object;

import com.fasterxml.jackson.annotation.JsonGetter;
import order.domain.entities.object.OrderDetail;

import java.math.BigDecimal;

public class OrderDetailResult {
    private int quantityOrdered;
    private BigDecimal priceEach;
    private int orderLineNumber;
    private ProductResult productResult;

    public OrderDetailResult() {

    }

    public OrderDetailResult(int quantityOrdered, BigDecimal priceEach, int orderLineNumber, ProductResult productResult) {
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
        this.productResult = productResult;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public int getOrderLineNumber() {
        return orderLineNumber;
    }

    public ProductResult getProductResult() {
        return productResult;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }

    public void setOrderLineNumber(int orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    public void setProductResult(ProductResult productResult) {
        this.productResult = productResult;
    }
}
package order.domain.entities.object;

import order.domain.value.object.ProductCode;

import java.math.BigDecimal;

public class OrderDetail {
    private ProductCode productCode;
    private Integer quantityOrdered;
    private BigDecimal priceEach;
    private Integer orderLineNumber;

    private Product product;

    public OrderDetail(ProductCode productCode, Integer quantityOrdered, BigDecimal priceEach, Integer orderLineNumber, Product product) {
        this.productCode = productCode;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
        this.product = product;
    }

    public ProductCode getProductCode() {
        return productCode;
    }

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public Integer getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}

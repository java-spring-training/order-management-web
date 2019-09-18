package web.domain.entities.object;

import web.domain.values.object.ProductCode;

public class OrderDetail {

    private Integer quanlityOrdered;
    private Integer priceEach;
    private Integer orderLineNumber;
    private ProductCode productCode;

    public OrderDetail(Integer quanlityOrdered, Integer priceEach, Integer orderLineNumber, ProductCode productCode) {
        this.quanlityOrdered = quanlityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
        this.productCode = productCode;
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

    public ProductCode getProductCode() {
        return productCode;
    }

    public void setProductCode(ProductCode productCode) {
        this.productCode = productCode;
    }


}

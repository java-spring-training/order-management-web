package order.domain.entities.object;

import order.domain.value.object.ProductCode;
import java.math.BigDecimal;

public class Product {
    private ProductCode productCode;
    private String productName;
    private BigDecimal buyPrice;

    public Product(ProductCode productCode, String productName, BigDecimal buyPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.buyPrice = buyPrice;
    }

    public ProductCode getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }
}

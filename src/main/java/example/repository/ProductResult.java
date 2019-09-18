package example.repository;

import java.math.BigDecimal;

public class ProductResult {
    private String productName;
    private BigDecimal buyPrice;

    public ProductResult() {
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }
}

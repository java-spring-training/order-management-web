package order.repository.results.object;

import java.math.BigDecimal;

public class ProductResult {
    private String productCode;
    private String productName;
    private BigDecimal buyPrice;

    public ProductResult()
    {

    }

    public ProductResult(String productCode, String productName,BigDecimal buyPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.buyPrice = buyPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }
}
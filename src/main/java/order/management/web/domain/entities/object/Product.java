package order.management.web.domain.entities.object;

import javax.validation.constraints.NotEmpty;

/**
 * Product
 */
public class Product {

    @NotEmpty
    private String productName;

    public Product(@NotEmpty String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
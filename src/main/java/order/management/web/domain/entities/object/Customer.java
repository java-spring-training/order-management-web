package order.management.web.domain.entities.object;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Customer {

    @NotEmpty
    private String customerName;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String country;

    private Employee salesRepEmployee;

    public Customer(@NotEmpty String customerName, @NotEmpty String phone,
            @NotEmpty String country, @NotNull Employee salesRepEmployee) {
        this.customerName = customerName;
        this.phone = phone;
        this.country = country;
        this.salesRepEmployee = salesRepEmployee;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Employee getSalesRepEmployee() {
        return salesRepEmployee;
    }

    public void setSalesRepEmployee(Employee salesRepEmployee) {
        this.salesRepEmployee = salesRepEmployee;
    }
}

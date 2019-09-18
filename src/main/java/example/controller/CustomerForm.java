package example.controller;

import javax.validation.constraints.Min;

public class CustomerForm {

    @Min(value = 10, message = "Please enter customer number")
    private Integer customerNumber;

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }
}

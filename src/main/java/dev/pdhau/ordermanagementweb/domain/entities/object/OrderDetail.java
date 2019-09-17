package dev.pdhau.ordermanagementweb.domain.entities.object;

import dev.pdhau.ordermanagementweb.domain.value.object.OrderNumberObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetail {

    private OrderNumberObject orderNumber;

    private String productCode;

    private Integer quantityOrdered;

    private Float priceEach;

    private Integer orderLineNumber;
}

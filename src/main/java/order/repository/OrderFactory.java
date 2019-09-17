package order.repository;

import order.domain.entities.object.*;
import order.domain.value.object.CustomerNumber;
import order.domain.value.object.EmployeeNumber;
import order.domain.value.object.OrderNumber;
import order.domain.value.object.ProductCode;
import order.repository.results.object.OrderDetailResult;
import order.repository.results.object.OrderResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderFactory {

    public List<Order> toListOrder(List<OrderResult> orderResultList) {

        return orderResultList.stream().map(this::toOrder).collect(Collectors.toList());
    }

    private Order toOrder(OrderResult orderResult) {

        EmployeeNumber employeeNumber = new EmployeeNumber(orderResult.getCustomerResult().getEmployeeResult().getEmployeeNumber());
        Employee employee = new Employee(employeeNumber, orderResult.getCustomerResult().getEmployeeResult().getEmail());

        CustomerNumber customerNumber = new CustomerNumber(orderResult.getCustomerResult().getCustomerNumber());
        Customer customer = new Customer(customerNumber
                , orderResult.getCustomerResult().getCustomerName()
                , orderResult.getCustomerResult().getPhone()
                , orderResult.getCustomerResult().getCity()
                , orderResult.getCustomerResult().getCountry()
                , employee
        );

        OrderNumber orderNumber = new OrderNumber(orderResult.getOrderNumber());
        Order order = new Order(
                orderNumber
                , orderResult.getOrderDate()
                , orderResult.getStatus()
                , customer
        );

        List<OrderDetail> orderDetailList = new ArrayList<>();
        for(OrderDetailResult orderDetailResult: orderResult.getOrderDetailResultList()) {
            ProductCode productCode = new ProductCode(orderDetailResult.getProductResult().getProductCode());
            Product product = new Product(productCode
                    , orderDetailResult.getProductResult().getProductName()
                    , orderDetailResult.getProductResult().getBuyPrice()
            );
            OrderDetail orderDetail = new OrderDetail(productCode
                    , orderDetailResult.getQuantityOrdered()
                    , orderDetailResult.getPriceEach()
                    , orderDetailResult.getOrderLineNumber()
                    , product
                    );
            orderDetailList.add(orderDetail);
        }

        order.setOrderDetailList(orderDetailList);

        return order;
    }

}

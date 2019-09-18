package web.controller;

import web.domain.entities.object.Order;
import web.domain.entities.object.OrderDetail;
import web.domain.values.object.OrderID;
import org.springframework.stereotype.Component;
import web.domain.values.object.ProductCode;
import web.repository.OrderRequest;

@Component
public class OrderFactory {
    public Order toOrder(OrderRequestBody orderRequestBody) {
        OrderDetail orderDetail = new OrderDetail(
                orderRequestBody.getQuanlityOrdered(),
                orderRequestBody.getPriceEach(),
                orderRequestBody.getOrderLineNumber(),
                new ProductCode(orderRequestBody.getProductCode()));
        Order order = new Order(new OrderID(orderRequestBody.getOrderId()), orderRequestBody.getOrderDate(),
                orderRequestBody.getRequiredDate(),
                orderRequestBody.getShippedDate(),
                orderRequestBody.getStatus(),
                orderRequestBody.getComments(),
                orderRequestBody.getCustomerNumber(),
                orderDetail);

        return order;
    }

    public OrderRequest toOrderRequest(Order order) {
        OrderRequest orderRequest = new OrderRequest(
                order.getOrderID().getOrderID(),
                order.getOrderDetail().getProductCode().getProductCode(),
                order.getOrderDate(),
                order.getRequiredDate(),
                order.getShippedDate(),
                order.getStatus(),
                order.getComments(),
                order.getCustomerNumber(),
                order.getOrderDetail().getQuanlityOrdered(),
                order.getOrderDetail().getPriceEach(),
                order.getOrderDetail().getOrderLineNumber()
        );
        return orderRequest;
    };
}

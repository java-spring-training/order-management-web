package example.domain;

import example.domain.entities.object.OrderDetail;
import example.exception.ApiErrorException;

import java.util.List;

public interface OrderRepository {
    List<OrderDetail> getListOrderByCustomerNumber(int customerNumber) throws ApiErrorException;
}

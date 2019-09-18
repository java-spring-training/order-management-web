package web.domain;

import web.repository.OrderRequest;

public interface OrderRepository {
    void editOrder(OrderRequest order);
}

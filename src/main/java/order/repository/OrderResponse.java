package order.repository;

import order.repository.results.object.OrderResult;

import java.util.List;

public class OrderResponse {

    private List<OrderResult> results;

    public OrderResponse()
    {

    }

    public List<OrderResult> getResults() {
        return results;
    }

}

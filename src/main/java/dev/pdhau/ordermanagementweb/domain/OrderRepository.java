package dev.pdhau.ordermanagementweb.domain;

import dev.pdhau.ordermanagementweb.domain.entities.object.Order;
import dev.pdhau.ordermanagementweb.exception.OrderApiErrorException;

public interface OrderRepository {

    public boolean add(Order order) throws OrderApiErrorException;
}

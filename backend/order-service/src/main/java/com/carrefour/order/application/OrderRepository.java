package com.carrefour.order.application;

import com.carrefour.order.domain.Order;
import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findByCustomerId(String customerId);
    Optional<Order> findById(String id);
    void save(Order order);
}

package com.carrefour.order.adapter.out.memory;

import com.carrefour.order.application.OrderRepository;
import com.carrefour.order.domain.Order;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryOrderRepository implements OrderRepository {
    private final Map<String, Order> byId = new ConcurrentHashMap<>();
    public Optional<Order> findByCustomerId(String customerId) { return byId.values().stream().filter(it -> it.customerId().equals(customerId)).findFirst(); }
    public Optional<Order> findById(String id) { return Optional.ofNullable(byId.get(id)); }
    public void save(Order order) { byId.put(order.id(), order); }
}

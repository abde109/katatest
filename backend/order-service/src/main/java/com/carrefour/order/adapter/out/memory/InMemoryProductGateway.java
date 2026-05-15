package com.carrefour.order.adapter.out.memory;

import com.carrefour.order.application.ProductGateway;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryProductGateway implements ProductGateway {
    private final Map<String, Integer> stock = new ConcurrentHashMap<>();
    public InMemoryProductGateway() { stock.put("P1", 50); stock.put("P2", 80); }
    public void reserve(String productId, int quantity) {
        int current = stock.getOrDefault(productId, 0);
        if (current < quantity) throw new IllegalStateException("Insufficient stock");
        stock.put(productId, current - quantity);
    }
    public void release(String productId, int quantity) { stock.put(productId, stock.getOrDefault(productId, 0) + quantity); }
}

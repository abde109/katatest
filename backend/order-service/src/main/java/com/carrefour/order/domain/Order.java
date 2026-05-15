package com.carrefour.order.domain;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Order {
    private final String id;
    private final String customerId;
    private final Map<String, Integer> lines;
    private OrderStatus status;
    private Instant confirmedAt;

    public Order(String id, String customerId) {
        this.id = id; this.customerId = customerId; this.lines = new HashMap<>(); this.status = OrderStatus.CART;
    }
    public void add(String productId, int quantity) { lines.merge(productId, quantity, Integer::sum); }
    public void remove(String productId, int quantity) {
        Integer existing = lines.getOrDefault(productId, 0);
        if (existing < quantity) throw new IllegalStateException("Cannot remove more than cart quantity");
        if (existing == quantity) lines.remove(productId); else lines.put(productId, existing - quantity);
    }
    public void confirm() {
        if (lines.isEmpty()) throw new IllegalStateException("Cannot confirm an empty cart");
        status = OrderStatus.CONFIRMED;
        confirmedAt = Instant.now();
    }
    public void cancel() {
        if (status != OrderStatus.CONFIRMED) throw new IllegalStateException("Only confirmed orders can be canceled");
        if (Instant.now().isAfter(confirmedAt.plus(1, ChronoUnit.HOURS))) throw new IllegalStateException("Cancellation window expired");
        status = OrderStatus.CANCELED;
    }
    public String id() { return id; }
    public String customerId() { return customerId; }
    public Map<String, Integer> lines() { return Collections.unmodifiableMap(lines); }
    public OrderStatus status() { return status; }
}

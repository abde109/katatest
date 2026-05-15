package com.carrefour.order.application;

public interface ProductGateway {
    void reserve(String productId, int quantity);
    void release(String productId, int quantity);
}

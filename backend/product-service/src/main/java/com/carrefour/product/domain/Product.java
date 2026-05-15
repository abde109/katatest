package com.carrefour.product.domain;

public record Product(String id, String name, int availableQuantity) {
    public Product reserve(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        if (availableQuantity < quantity) throw new IllegalStateException("Insufficient stock");
        return new Product(id, name, availableQuantity - quantity);
    }

    public Product release(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        return new Product(id, name, availableQuantity + quantity);
    }
}

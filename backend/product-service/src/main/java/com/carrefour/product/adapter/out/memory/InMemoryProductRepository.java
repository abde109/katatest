package com.carrefour.product.adapter.out.memory;

import com.carrefour.product.application.ProductRepository;
import com.carrefour.product.domain.Product;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryProductRepository implements ProductRepository {
    private final Map<String, Product> products = new ConcurrentHashMap<>();

    public InMemoryProductRepository() {
        save(new Product("P1", "Milk", 50));
        save(new Product("P2", "Bread", 80));
    }

    public Optional<Product> findById(String id) { return Optional.ofNullable(products.get(id)); }
    public List<Product> findAll() { return products.values().stream().toList(); }
    public void save(Product product) { products.put(product.id(), product); }
}

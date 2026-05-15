package com.carrefour.product.application;

import com.carrefour.product.domain.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(String id);
    List<Product> findAll();
    void save(Product product);
}

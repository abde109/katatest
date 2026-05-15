package com.carrefour.product.application;

import com.carrefour.product.domain.Product;
import java.util.List;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) { this.productRepository = productRepository; }

    public List<Product> listProducts() { return productRepository.findAll(); }

    public void reserve(String productId, int quantity) {
        Product product = productRepository.findById(productId).orElseThrow();
        productRepository.save(product.reserve(quantity));
    }

    public void release(String productId, int quantity) {
        Product product = productRepository.findById(productId).orElseThrow();
        productRepository.save(product.release(quantity));
    }
}

package com.carrefour.product.config;

import com.carrefour.product.adapter.out.memory.InMemoryProductRepository;
import com.carrefour.product.application.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {
    @Bean InMemoryProductRepository productRepository() { return new InMemoryProductRepository(); }
    @Bean ProductService productService(InMemoryProductRepository repository) { return new ProductService(repository); }
}

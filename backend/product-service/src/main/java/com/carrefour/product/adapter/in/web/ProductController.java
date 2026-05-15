package com.carrefour.product.adapter.in.web;

import com.carrefour.product.application.ProductService;
import com.carrefour.product.domain.Product;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) { this.productService = productService; }
    @GetMapping public List<Product> listProducts() { return productService.listProducts(); }
}

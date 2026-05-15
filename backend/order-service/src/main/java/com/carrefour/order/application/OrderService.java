package com.carrefour.order.application;

import com.carrefour.order.domain.Order;

import java.util.UUID;

public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductGateway productGateway;

    public OrderService(OrderRepository orderRepository, ProductGateway productGateway) {
        this.orderRepository = orderRepository;
        this.productGateway = productGateway;
    }

    public Order addToCart(String customerId, String productId, int quantity) {
        Order order = orderRepository.findByCustomerId(customerId).orElse(new Order(UUID.randomUUID().toString(), customerId));
        productGateway.reserve(productId, quantity);
        order.add(productId, quantity);
        orderRepository.save(order);
        return order;
    }

    public Order removeFromCart(String customerId, String productId, int quantity) {
        Order order = orderRepository.findByCustomerId(customerId).orElseThrow();
        order.remove(productId, quantity);
        productGateway.release(productId, quantity);
        orderRepository.save(order);
        return order;
    }

    public Order confirm(String orderId) { Order o = orderRepository.findById(orderId).orElseThrow(); o.confirm(); orderRepository.save(o); return o; }
    public Order cancel(String orderId) { Order o = orderRepository.findById(orderId).orElseThrow(); o.cancel(); o.lines().forEach(productGateway::release); orderRepository.save(o); return o; }
}

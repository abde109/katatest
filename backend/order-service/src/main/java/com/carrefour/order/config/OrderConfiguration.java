package com.carrefour.order.config;

import com.carrefour.order.adapter.out.memory.InMemoryOrderRepository;
import com.carrefour.order.adapter.out.memory.InMemoryProductGateway;
import com.carrefour.order.application.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfiguration {
    @Bean InMemoryOrderRepository orderRepository() { return new InMemoryOrderRepository(); }
    @Bean InMemoryProductGateway productGateway() { return new InMemoryProductGateway(); }
    @Bean OrderService orderService(InMemoryOrderRepository orderRepository, InMemoryProductGateway productGateway) {
        return new OrderService(orderRepository, productGateway);
    }
}

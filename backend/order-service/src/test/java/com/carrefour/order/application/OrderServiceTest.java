package com.carrefour.order.application;

import com.carrefour.order.adapter.out.memory.InMemoryOrderRepository;
import com.carrefour.order.adapter.out.memory.InMemoryProductGateway;
import com.carrefour.order.domain.Order;
import com.carrefour.order.domain.OrderStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    @Test
    void shouldAddAndRemoveProductFromCartAndConfirmOrder() {
        OrderService orderService = new OrderService(new InMemoryOrderRepository(), new InMemoryProductGateway());
        Order cart = orderService.addToCart("C1", "P1", 2);
        assertEquals(2, cart.lines().get("P1"));

        Order updated = orderService.removeFromCart("C1", "P1", 1);
        assertEquals(1, updated.lines().get("P1"));

        Order confirmed = orderService.confirm(updated.id());
        assertEquals(OrderStatus.CONFIRMED, confirmed.status());
    }
}

package com.carrefour.order.adapter.in.web;

import com.carrefour.order.application.OrderService;
import com.carrefour.order.domain.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @PostMapping("/cart/add")
    public Order addToCart(@RequestBody CartLineRequest request) { return orderService.addToCart(request.customerId(), request.productId(), request.quantity()); }
    @PostMapping("/cart/remove")
    public Order removeFromCart(@RequestBody CartLineRequest request) { return orderService.removeFromCart(request.customerId(), request.productId(), request.quantity()); }
    @PostMapping("/{orderId}/confirm")
    public Order confirm(@PathVariable String orderId) { return orderService.confirm(orderId); }
    @PostMapping("/{orderId}/cancel")
    public Order cancel(@PathVariable String orderId) { return orderService.cancel(orderId); }

    public record CartLineRequest(String customerId, String productId, int quantity) {}
}

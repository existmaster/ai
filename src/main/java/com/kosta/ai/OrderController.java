package com.kosta.ai;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/place")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        order.setStatus(Order.OrderStatus.PLACED);
        order.setOrderDate(LocalDateTime.now());
        Order savedOrder = orderRepository.save(order);
        // Here you would typically add logic for notifying the restaurant, updating inventory, etc.
        return ResponseEntity.ok(savedOrder);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<? extends Object> cancelOrder(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(order -> {
                    if (order.getStatus() == Order.OrderStatus.PLACED || order.getStatus() == Order.OrderStatus.PREPARING) {
                        order.setStatus(Order.OrderStatus.CANCELLED);
                        return ResponseEntity.ok(orderRepository.save(order));
                    } else {
                        return ResponseEntity.badRequest().build();
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
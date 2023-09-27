package com.template.controller;

import java.util.List;
import java.util.UUID;

import com.template.service.Order;
import com.template.service.OrderRepository;
import com.template.service.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderRepository orderRepository;


    @GetMapping("/{id}")
    public Order getOrder(@PathVariable UUID id) {
        return orderRepository.getOrderById(id);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @PostMapping
    public void addOrder(@RequestBody List<Product> products) {
        orderRepository.addOrder(products);
    }
}

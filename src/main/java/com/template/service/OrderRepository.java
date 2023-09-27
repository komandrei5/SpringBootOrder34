package com.template.service;

import java.util.List;
import java.util.UUID;

public interface OrderRepository {
    Order getOrderById(UUID id);
    List<Order> getAllOrders();

    void addOrder(List<Product> product);
}

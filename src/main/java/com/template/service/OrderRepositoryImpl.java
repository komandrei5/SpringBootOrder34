package com.template.service;

import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.*;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private static List<Order> orderList;

    public OrderRepositoryImpl() {
        orderList = new ArrayList<>();
    }

    @Override
    public Order getOrderById(UUID id) {

        return orderList.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderList;
    }

    @Override
    public void addOrder(List<Product> product) {
        Order order = new Order();
        order.setid(UUID.randomUUID());
        order.setCreateAt(new Timestamp(System.currentTimeMillis()));
        order.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        order.setProducts(product);
        order.setCost(order.getProducts().stream().mapToDouble(Product::getCost).sum());

        orderList.add(order);
    }
}

package org.example.demo.service;

import org.example.demo.model.Order;
import org.example.demo.model.User;
import org.example.demo.repository.OrderRepository;
import org.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public Order createOrder(Long userId, String productName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Order order = new Order();
        order.setUser(user);
        order.setProductName(productName);
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}


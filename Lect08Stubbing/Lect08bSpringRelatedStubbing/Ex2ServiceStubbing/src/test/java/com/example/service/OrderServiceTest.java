package com.example.service;

import com.example.demo.model.Order;
import com.example.demo.model.User;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class OrderServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Test
    public void testCreateOrder() {
        User user = userService.createUser("John", "john@example.com");
        Order order = orderService.createOrder(user.getId(), "Laptop");

        assertEquals("Laptop", order.getProductName());
        assertEquals("John", order.getUser().getName());
    }

    @Test
    public void testGetOrdersByUserId() {
        User user = userService.createUser("Jane", "jane@example.com");
        orderService.createOrder(user.getId(), "Smartphone");
        orderService.createOrder(user.getId(), "Tablet");

        List<Order> orders = orderService.getOrdersByUserId(user.getId());
        assertEquals(2, orders.size());
    }

}

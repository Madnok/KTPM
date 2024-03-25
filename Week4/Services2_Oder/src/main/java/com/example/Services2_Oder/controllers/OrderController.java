package com.example.Services2_Oder.controllers;


import com.example.Services2_Oder.models.Order;
import com.example.Services2_Oder.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    @Cacheable(value = "orders")
    public List<Order> getLisOrder(){
        return  orderService.getListOrder();
    }

    @GetMapping("/orders/{id}")
    @Cacheable(value = "order", key = "#id")
    public Order getUserById(@PathVariable(value = "id") long id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    @CachePut(value = "order", key = "#result.id")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @DeleteMapping("/orders/{orderId}")
    @CacheEvict(value = "order")
    public void deleteOrder(@PathVariable(value = "orderId") long orderId){
        orderService.deleteOrderById(orderId);
    }
}

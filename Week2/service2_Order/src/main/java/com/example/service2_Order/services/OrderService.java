package com.example.service2_Order.services;

import com.example.service2_Order.models.Order;
import com.example.service2_Order.repositories.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<Order> getListUser(){
        return  orderRepository.findAll();
    }

    public Order getUserById(long id){
        return orderRepository.findById(id).get();
    }
}
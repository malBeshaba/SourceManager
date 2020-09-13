package com.example.demo.service;


import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findByUserId(int user_id){
        return orderRepository.findByUserId(user_id);
    }

    public void deleteByOrderId(int order_id){
        orderRepository.deleteByOrderId(order_id);
    }
}

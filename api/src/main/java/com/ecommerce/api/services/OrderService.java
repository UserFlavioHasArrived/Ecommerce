package com.ecommerce.api.services;

import com.ecommerce.api.dto.OrderDTO;
import com.ecommerce.api.entities.Order;
import com.ecommerce.api.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public OrderDTO getOrderById(Long id) {
       Order order = orderRepository.findById(id).orElseThrow();
       return new OrderDTO(order.getId(), order.getMoment(), order.getStatus(), order.getUser(), order.getPayment());
    }


    }



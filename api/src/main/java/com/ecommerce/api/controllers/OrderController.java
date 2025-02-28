package com.ecommerce.api.controllers;

import com.ecommerce.api.dto.OrderDTO;
import com.ecommerce.api.dto.OrderItemDTO;
import com.ecommerce.api.dto.PaymentDTO;
import com.ecommerce.api.dto.UserDTO;
import com.ecommerce.api.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
    @GetMapping("/{id}/items")
    public ResponseEntity<List<OrderItemDTO>> getOrderItemsById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderItemsById(id));
    }
    @GetMapping("/{id}/payment")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getPaymentById(id));
    }
    @GetMapping("/{id}/user")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getUserById(id));
    }

}

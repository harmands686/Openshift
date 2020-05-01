package com.harman.orderapi.controller;

import com.harman.orderapi.exception.OrderNotFoundException;
import com.harman.orderapi.model.Order;
import com.harman.orderapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController {

@Autowired
    OrderRepository OrderRepository;

// Get All Orders
	@GetMapping("/orders")
    public List<Order> getAllOrders() {
        return OrderRepository.findAll();
    }

// Create a new Order
    @PostMapping("/orders")
    public Order createOrderOrder(@Valid @RequestBody Order order) {
        return OrderRepository.save(order);
    }

// Get a Single Order
    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable(value = "id") Long orderId) throws OrderNotFoundException {
        return OrderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
    }

// Update a Order
    @PutMapping("/orders/{id}")
    public Order updateOrder(@PathVariable(value = "id") Long orderId,
                           @Valid @RequestBody Order orderDetails) throws OrderNotFoundException {

Order order = OrderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));

order.setCust_name(orderDetails.getCust_name());
order.setCust_adrs(orderDetails.getCust_adrs());
order.setPrd(orderDetails.getPrd());
order.setQty(orderDetails.getQty());

Order updatedOrder = OrderRepository.save(order);

return updatedOrder;
    }

// Delete a Order
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable(value = "id") Long orderId) throws OrderNotFoundException {
        Order order = OrderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));

OrderRepository.delete(order);

return ResponseEntity.ok().build();
    }
}
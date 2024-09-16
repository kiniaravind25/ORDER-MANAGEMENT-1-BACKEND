package com.ssv.backendProject.controller;

import com.ssv.backendProject.dto.CreateOrderRequest;
import com.ssv.backendProject.dto.OrderStatusRequest;
import com.ssv.backendProject.entity.Order;
import com.ssv.backendProject.entity.OrderItem;
import com.ssv.backendProject.mappers.OrderMapper;
import com.ssv.backendProject.model.OrderModel;
import com.ssv.backendProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    OrderMapper orderMapper;

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderRequest request) {
        Order order = orderService.createOrder(request.getUserId(), request.getItems());
        return ResponseEntity.ok(order);
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long orderId, @RequestBody OrderStatusRequest statusRequest) {
        Order order = orderService.updateOrderStatus(orderId, statusRequest.getStatus());
        return ResponseEntity.ok(order);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderModel>> getOrdersByUser(@PathVariable Long userId) {
        List<Order> orders = orderService.getOrdersByUserId(userId);
        List<OrderModel> orderModel = orders.stream()
                .map(orderMapper::orderToOderModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(orderModel);
    }

    @GetMapping("/orderItem/{orderId}")
    public ResponseEntity<List<OrderItem>> getOrdersByOrder(@PathVariable Long orderId) {
        List<OrderItem> orders = orderService.getOrdersByOrderId(orderId);
        return ResponseEntity.ok(orders);
    }


}

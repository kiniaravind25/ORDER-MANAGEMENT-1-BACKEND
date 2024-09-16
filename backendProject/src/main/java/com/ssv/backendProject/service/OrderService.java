package com.ssv.backendProject.service;

import com.ssv.backendProject.dto.CreateOrderItemRequest;
import com.ssv.backendProject.entity.*;
import com.ssv.backendProject.enums.OrderStatus;
import com.ssv.backendProject.repository.ItemRepository;
import com.ssv.backendProject.repository.OrderItemRepository;
import com.ssv.backendProject.repository.OrderRepository;
import com.ssv.backendProject.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public Order createOrder(Long userId, List<CreateOrderItemRequest> itemRequests) {
        // Fetch the user
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Order order = new Order();
        order.setUser(user);
        order.setStatus(OrderStatus.PENDING);  // Initial status is PENDING
        double totalPrice = 0.0;

        List<OrderItem> orderItems = new ArrayList<>();

        for (CreateOrderItemRequest itemRequest : itemRequests) {
            // Fetch the item from the repository
            Item item = itemRepository.findById(itemRequest.getItemId())
                    .orElseThrow(() -> new RuntimeException("Item not found"));

            // Check stock
            if (item.getStockQuantity() < itemRequest.getQuantity()) {
                throw new RuntimeException("Insufficient stock for item: " + item.getName());
            }

            // Decrease stock
            item.setStockQuantity(item.getStockQuantity() - itemRequest.getQuantity());
            itemRepository.save(item);  // Save the updated item

            // Create OrderItem and calculate total price
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItem.setPricePerItem(item.getPrice());
            orderItem.setOrder(order);

            totalPrice += item.getPrice() * itemRequest.getQuantity();
            orderItems.add(orderItem);
        }

        order.setItems(orderItems);
        order.setTotalPrice(totalPrice);

        // Save the order
        return orderRepository.save(order);
    }

    public Order updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUserId(Long userId) {

        return orderRepository.findByUserId(userId);
    }

    public List<OrderItem> getOrdersByOrderId(Long orderId) {

        return orderItemRepository.findByOrderId(orderId);
    }
}

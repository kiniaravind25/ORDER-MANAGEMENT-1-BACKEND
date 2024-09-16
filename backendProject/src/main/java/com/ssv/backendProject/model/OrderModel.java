package com.ssv.backendProject.model;


import com.ssv.backendProject.entity.OrderItem;
import com.ssv.backendProject.entity.User;
import com.ssv.backendProject.enums.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {

    private Long id;
    private User user;
    private List<OrderItem> items;
    private Double totalPrice;
    private LocalDateTime orderDate;
    private OrderStatus status;
}

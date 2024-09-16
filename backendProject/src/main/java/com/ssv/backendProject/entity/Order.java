package com.ssv.backendProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ssv.backendProject.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;  // Each order is associated with one user

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;  // An order can have multiple order items

    private Double totalPrice;

    private LocalDateTime orderDate = LocalDateTime.now();  // Timestamp of the order

    @Enumerated(EnumType.STRING)
    private OrderStatus status;  // The status of the order: PENDING, SHIPPED, etc.
}

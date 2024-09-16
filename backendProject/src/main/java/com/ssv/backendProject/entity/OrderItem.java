package com.ssv.backendProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonBackReference
    private Order order;  // Each order item is associated with one order

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;  // Each order item refers to one item

    @Column(nullable = false)
    private Integer quantity;  // Quantity of the item ordered

    @Column(nullable = false)
    private Double pricePerItem;  // Price per item when ordered
}

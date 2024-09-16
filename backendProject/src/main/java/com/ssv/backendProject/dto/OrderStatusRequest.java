package com.ssv.backendProject.dto;

import com.ssv.backendProject.enums.OrderStatus;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusRequest {
    private OrderStatus status;

}

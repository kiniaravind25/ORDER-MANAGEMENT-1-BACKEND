package com.ssv.backendProject.mappers;

import com.ssv.backendProject.entity.Order;
import com.ssv.backendProject.model.OrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "orderDate",ignore = true)
    @Mapping(target = "status", ignore = true)
    OrderModel orderToOderModel(Order order);



}

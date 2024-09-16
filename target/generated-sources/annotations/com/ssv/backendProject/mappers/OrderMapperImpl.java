package com.ssv.backendProject.mappers;

import com.ssv.backendProject.entity.Order;
import com.ssv.backendProject.entity.OrderItem;
import com.ssv.backendProject.model.OrderModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-14T14:12:45+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderModel orderToOderModel(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderModel orderModel = new OrderModel();

        orderModel.setId( order.getId() );
        orderModel.setUser( order.getUser() );
        List<OrderItem> list = order.getItems();
        if ( list != null ) {
            orderModel.setItems( new ArrayList<OrderItem>( list ) );
        }
        orderModel.setTotalPrice( order.getTotalPrice() );

        return orderModel;
    }
}

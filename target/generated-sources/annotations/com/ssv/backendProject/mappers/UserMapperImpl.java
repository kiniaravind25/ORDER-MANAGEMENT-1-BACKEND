package com.ssv.backendProject.mappers;

import com.ssv.backendProject.entity.Order;
import com.ssv.backendProject.entity.User;
import com.ssv.backendProject.model.UserModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-14T14:07:00+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserModel userToUserModel(User user) {
        if ( user == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( user.getId() );
        userModel.setUsername( user.getUsername() );
        userModel.setEmail( user.getEmail() );
        List<Order> list = user.getOrders();
        if ( list != null ) {
            userModel.setOrders( new ArrayList<Order>( list ) );
        }

        return userModel;
    }

    @Override
    public User userModelToUser(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        User user = new User();

        user.setId( userModel.getId() );
        user.setUsername( userModel.getUsername() );
        user.setEmail( userModel.getEmail() );
        List<Order> list = userModel.getOrders();
        if ( list != null ) {
            user.setOrders( new ArrayList<Order>( list ) );
        }

        return user;
    }
}

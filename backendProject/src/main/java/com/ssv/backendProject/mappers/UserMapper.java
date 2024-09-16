package com.ssv.backendProject.mappers;

import com.ssv.backendProject.entity.User;
import com.ssv.backendProject.model.UserModel;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {


    UserModel userToUserModel(User user);


    User userModelToUser(UserModel userModel);
}

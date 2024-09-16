//package com.ssv.backendProject.dto;
//
//import com.ssv.backendProject.entity.User;
//import com.ssv.backendProject.model.UserModel;
//
//public  class UserToUserModel {
//
//    public static UserModel entityToModel(User user) {
//        UserModel userModel = new UserModel();
//        userModel.setId(user.getId());
//        userModel.setUsername(user.getUsername());
//        userModel.setRoles(user.getRoles());
//        return userModel;
//
//    }
//
//    public static User modelToEntity(UserModel userModel) {
//        User user = new User();
//        user.setId(userModel.getId());
//        user.setUsername(userModel.getUsername());
//        user.setRoles(userModel.getRoles());
//        user.setPassword(userModel.getPassword());
//        return user;
//
//    }
//}

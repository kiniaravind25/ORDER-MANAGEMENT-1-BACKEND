package com.ssv.backendProject.service;

import com.ssv.backendProject.Execption.InvalidUserException;
import com.ssv.backendProject.entity.User;
import com.ssv.backendProject.mappers.UserMapper;
import com.ssv.backendProject.model.UserModel;
import com.ssv.backendProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public UserModel addUsers(UserModel userModel) throws InvalidUserException {


            User user = userMapper.userModelToUser(userModel);
            User savedUser = userRepository.save(user);
            return userMapper.userToUserModel(savedUser);

    }

    public void deleteItem(Long id) {
        userRepository.deleteById(id);
    }

        public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}

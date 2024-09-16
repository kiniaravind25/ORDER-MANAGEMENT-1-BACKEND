package com.ssv.backendProject.controller;

import com.ssv.backendProject.Execption.InvalidUserException;
import com.ssv.backendProject.entity.User;
import com.ssv.backendProject.model.UserModel;
import com.ssv.backendProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserModel> addUsers(@RequestBody UserModel userModel) throws InvalidUserException {
        return new ResponseEntity<>(userService.addUsers(userModel), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        userService.deleteItem(id);
    }


    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

}

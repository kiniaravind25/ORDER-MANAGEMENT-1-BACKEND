package com.ssv.backendProject.model;


import com.ssv.backendProject.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class UserModel {

    private Long id;

    private String username;

    private String email;

    private List<Order> orders;


}

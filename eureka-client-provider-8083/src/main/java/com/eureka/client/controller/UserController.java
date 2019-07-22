package com.eureka.client.controller;

import com.eureka.client.Response;
import css.erueka.api.UserApi;
import css.erueka.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    @Resource
    private UserApi userApi;

    @GetMapping("/getAllUsers")
    public Response<List<User>> getAllUsers(){
        System.out.println(userApi.getAllUsers());
        return userApi.getAllUsers();
}
}
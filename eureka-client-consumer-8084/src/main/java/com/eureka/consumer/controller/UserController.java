package com.eureka.consumer.controller;

import com.eureka.consumer.feginclient.UserApiFeignClient;
import com.eureka.client.Response;
import css.erueka.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    @Resource
    private UserApiFeignClient userApiFeignClient;

    @GetMapping("/getAllUsers")
    public Response<List<User>> getAllUsers(){
        System.out.println("UserController===========>aaaaaaaaaaaaa");
        //System.out.println(userApiFeignClient.getAllUsers().getData().size());
        return userApiFeignClient.getAllUsers();
    }
}

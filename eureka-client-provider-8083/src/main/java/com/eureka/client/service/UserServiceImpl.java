package com.eureka.client.service;
import com.eureka.client.config.RedisUtils;
import com.eureka.client.mapper.UserMapper;
import com.eureka.client.Response;
import com.eureka.client.ResponseApi;
import css.erueka.api.UserApi;
import css.erueka.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl<T> extends ResponseApi<T> implements UserApi {
    @Resource
    private UserMapper userMapper;
    @Override
    public Response<List<User>> getAllUsers() {
        List<User> list = userMapper.getAllUsers();
        Boolean a = RedisUtils.set("key2",list.toString());
        System.out.println(a);
        return setSuccess(list);
    }
}

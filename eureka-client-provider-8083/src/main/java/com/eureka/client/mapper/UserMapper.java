package com.eureka.client.mapper;

import css.erueka.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getAllUsers();
}

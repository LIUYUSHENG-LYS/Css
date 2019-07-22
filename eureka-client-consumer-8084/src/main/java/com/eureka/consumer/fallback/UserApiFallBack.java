package com.eureka.consumer.fallback;

import com.eureka.consumer.feginclient.UserApiFeignClient;
import com.eureka.client.Response;
import com.eureka.client.ResponseApi;
import css.erueka.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserApiFallBack extends ResponseApi implements UserApiFeignClient {
    @Override
    public Response<List<User>> getAllUsers() {
        return setWait(null);
    }
}

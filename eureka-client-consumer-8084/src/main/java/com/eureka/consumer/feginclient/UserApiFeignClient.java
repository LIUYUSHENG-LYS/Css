package com.eureka.consumer.feginclient;
import com.eureka.consumer.fallback.UserApiFallBack;
import css.erueka.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "provider-client",fallback = UserApiFallBack.class)
public interface UserApiFeignClient extends UserApi  {

}

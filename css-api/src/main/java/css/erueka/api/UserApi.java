package css.erueka.api;


import com.eureka.client.Response;
import css.erueka.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface UserApi {
    @GetMapping("/getAllUsers")
    Response<List<User>> getAllUsers();

}

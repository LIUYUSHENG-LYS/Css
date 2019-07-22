package css.erueka.api;

import com.eureka.client.Response;
import css.erueka.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface EsApi {
    @GetMapping("/selectEs/{name}")
    Response<List<User>> getAllUsers();
}

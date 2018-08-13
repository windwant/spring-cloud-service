package org.windwant.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.windwant.common.model.User;

/**
 * Created by Administrator on 18-8-13.
 */
@Component
public class HelloServiceCallback implements HelloService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(@RequestParam("name") String name) {
        return "error";
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") int age) {
        return new User("error", 0);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "error";
    }
}

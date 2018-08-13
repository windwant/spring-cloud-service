package org.windwant.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.windwant.common.model.User;

/**
 * Created by Administrator on 18-8-13.
 */
@FeignClient(name = "hello-service", fallback = HelloServiceCallback.class)
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping("/hello/1")
    String hello(@RequestParam("name") String name);

    @RequestMapping("/hello/2")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") int age);

    @RequestMapping("/hello/3")
    String hello(@RequestBody User user);
}

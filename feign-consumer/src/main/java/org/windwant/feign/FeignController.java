package org.windwant.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.windwant.common.model.User;

/**
 * Created by Administrator on 18-8-13.
 */
@RestController
public class FeignController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/feign-consumer")
    public String helloConsumer(){
        return helloService.hello();
    }

    @RequestMapping("/feign-consumer1")
    public String helloConsumerx(){
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello("roger") + "\r\n");
        sb.append(helloService.hello("windwant", 10) + "\r\n");
        sb.append(helloService.hello(new User("root",11)) + "\r\n");
        System.out.println(sb.toString());
        return sb.toString();
    }
}

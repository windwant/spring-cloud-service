package org.windwant.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.windwant.ribbon.service.HelloService;

/**
 * Created by Administrator on 18-8-10.
 */
@RestController
public class ConsumerController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/ribbon-consumer")
    public String helloConsumer(){
        return helloService.helloService();
    }
}

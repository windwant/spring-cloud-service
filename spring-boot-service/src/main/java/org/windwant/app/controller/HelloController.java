package org.windwant.app.controller;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.windwant.common.model.User;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Administrator on 18-8-9.
 */
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String index(){
        StringBuilder sb = new StringBuilder();
        client.getInstances("hello-service").forEach(item-> {
            sb.append("host: " + item.getHost() + "\r\n");
            sb.append("port: " + item.getPort() + "\r\n");
            sb.append("serviceId: " + item.getServiceId() + "\r\n");
            sb.append("uri: " + item.getUri() + "\r\n");
            sb.append("meta: " + ToStringBuilder.reflectionToString(item.getMetadata()));
        });
        System.out.println(sb.toString());
        try {
            int sleepTime = ThreadLocalRandom.current().nextInt(3000);
            System.out.println("request expense: " + sleepTime);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @RequestMapping("/hello/1")
    public String index(@RequestParam String name){
        return "hello: " + name;
    }

    @RequestMapping("/hello/2")
    public User index(@RequestHeader String name, @RequestHeader int age){
        return new User(name, age);
    }

    @RequestMapping("/hello/3")
    public String index(@RequestBody User user){
        return "hello: " + user.getName() + ", age: " + user.getAge();
    }
}

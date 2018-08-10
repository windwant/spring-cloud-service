package org.windwant.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 18-8-10.
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${remote.server.name}")
    private String serverName;

    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String helloService(){
        return restTemplate.getForEntity(serverName, String.class).getBody();
    }

    private String helloFallBack(){
        return "error";
    }
}

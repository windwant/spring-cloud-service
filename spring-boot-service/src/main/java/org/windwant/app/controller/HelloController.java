package org.windwant.app.controller;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return sb.toString();
    }
}

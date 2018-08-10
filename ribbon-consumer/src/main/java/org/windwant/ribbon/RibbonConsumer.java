package org.windwant.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class RibbonConsumer {


	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplateBuilder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(RibbonConsumer.class, args);
	}
}

package org.windwant.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {

	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}

	public static void main(String[] args) {
		new SpringApplication(ZuulApplication.class).run(ZuulApplication.class, args);
	}
}

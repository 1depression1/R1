package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class SpringcloudZuul {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SpringcloudZuul.class, args);
	}

}

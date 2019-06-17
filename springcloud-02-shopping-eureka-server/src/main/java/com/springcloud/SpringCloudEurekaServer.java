package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 当前项目要启动Eureka的服务器
public class SpringCloudEurekaServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SpringCloudEurekaServer.class, args);
	}

}

package com.example.lab6apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Lab6ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab6ApiGatewayApplication.class, args);
	}

}

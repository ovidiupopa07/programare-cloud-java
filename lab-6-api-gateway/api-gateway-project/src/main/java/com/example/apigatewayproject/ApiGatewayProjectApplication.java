package com.example.apigatewayproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayProjectApplication.class, args);
	}

}

package com.example.service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaClient
public class Service2Application {

	public static void main(String[] args) {
		SpringApplication.run(Service2Application.class, args);
	}
	// TODO
	// 1. define a POST endpoint /product which should accept a request body containing two properties -product name and quantity
	//2. save the request body in memory
	// 3. return 200 if OK
	// 4. print request headers
	// 5. register the service in eureka
	// 6. define a GET endpoint /product to return the saved data using the POST endpoint - return type is List<Product>
}

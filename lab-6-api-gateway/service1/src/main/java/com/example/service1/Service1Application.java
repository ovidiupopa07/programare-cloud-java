package com.example.service1;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Service1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}
	
	@GetMapping("api/greeting")
	public String greet(@RequestHeader Map<String, String> headers, @RequestParam String name) {
		System.out.println(headers);
		return "Hello " + name;
	}
	// TODO
	// 1. define a GET endpoint /api/greeting which should accept a query parameter "name"
	// 2. return should be a string returning a greeting: Hello Brasov
	// 3. print request headers
	// 4. register the service in eureka
	
}

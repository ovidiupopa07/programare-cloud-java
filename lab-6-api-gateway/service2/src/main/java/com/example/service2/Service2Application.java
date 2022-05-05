package com.example.service2;

import com.example.service2.repository.ProductRepository;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Service2Application {
	
	private final ProductRepository productRepository;
	
	public Service2Application(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Service2Application.class, args);
	}
	
	
	@PostMapping("product")
	public ResponseEntity<?> postProduct(@RequestBody Product product) {
		try {
			var prod = productRepository.saveProduct(product);
			return ResponseEntity.ok(prod);
		} catch (RuntimeException exception) {
			return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body(exception.getMessage());
		}
	}
	
	// TODO
	// 1. define a POST endpoint /product which should accept a request body containing two properties -product name and quantity
	//2. save the request body in memory
	// 3. return 200 if OK
	// 4. print request headers
	// 5. register the service in eureka
	// 6. define a GET endpoint /product to return the saved data using the POST endpoint - return type is List<Product>
}


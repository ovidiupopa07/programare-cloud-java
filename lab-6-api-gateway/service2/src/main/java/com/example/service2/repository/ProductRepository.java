package com.example.service2.repository;

import com.example.service2.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
	List<Product> products = new ArrayList<>();
	
	public Optional<Product> findProductByName(String name) {
		return products.stream().filter(product -> product.getName().equals(name)).findFirst();
	}
	
	public Product saveProduct(Product product) {
		findProductByName(product.getName()).ifPresent(r -> {
			throw new RuntimeException("Product with name " + r.getName() + " already exists!");
		});
		
		products.add(product);
		
		return product;
	}
}

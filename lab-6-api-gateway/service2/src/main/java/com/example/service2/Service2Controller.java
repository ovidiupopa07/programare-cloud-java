package com.example.service2;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class Service2Controller {

    private List<Product> products = new ArrayList<Product>();

    @ResponseStatus(HttpStatus.OK)
    @PostMapping()
    public void addProduct(@RequestBody Product product, @RequestHeader Map<String, String> headers) {
    	for(Map.Entry<String,String> header : headers.entrySet()) {
        	System.out.println(header);
        }
        products.add(product);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProducts(@RequestHeader Map<String, String> headers) {
    	for(Map.Entry<String,String> header : headers.entrySet()) {
        	System.out.println(header);
        }
        return products;
    }
} 
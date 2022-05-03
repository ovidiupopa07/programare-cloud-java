package com.example.service2.controller;

import com.example.service2.model.Product;
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

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public void addProduct(@RequestBody Product product, @RequestHeader Map<String, String> headers) {
        for (Map.Entry<String, String> header : headers.entrySet()) {
            System.out.println(header);
        }
        products.add(product);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProducts(@RequestHeader Map<String, String> headers) {
        for (Map.Entry<String, String> header : headers.entrySet()) {
            System.out.println(header);
        }
        return products;
    }
}

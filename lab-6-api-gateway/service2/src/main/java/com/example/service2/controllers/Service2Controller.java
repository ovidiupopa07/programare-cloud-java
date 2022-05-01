package com.example.service2.controllers;

import com.example.service2.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class Service2Controller {

    private List<Product> products;

    public Service2Controller() {
        products = new ArrayList<Product>();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProducts(@RequestHeader Map<String, String> headers) {

        System.out.println("Headers: ");
        for(Map.Entry<String,String> header : headers.entrySet()) {
            System.out.println(header);
        }

        return products;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping()
    public void addProduct(@RequestBody Product product, @RequestHeader Map<String, String> headers) {
        products.add(product);

        System.out.println("Headers: ");
        for(Map.Entry<String,String> header : headers.entrySet()) {
            System.out.println(header);
        }
    }
}

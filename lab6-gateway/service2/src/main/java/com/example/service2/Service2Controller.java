package com.example.service2;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class Service2Controller {

    private static ArrayList<Product> products = new ArrayList<>();

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getList() {
        return products;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String list(@RequestHeader Map<String, String> headers, @RequestBody Product product) {
        products.add(product);
        System.out.println("Headers {" + headers + "}");
        return "Hello Brasov";
    }
}

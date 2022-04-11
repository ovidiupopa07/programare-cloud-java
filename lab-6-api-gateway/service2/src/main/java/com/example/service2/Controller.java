package com.example.service2;


import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class Controller {

    private List<Product> products = new ArrayList<>();

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void greeting(@RequestBody Product product, @NotNull BindingResult result) {
        if(result.hasErrors())
            throw new RuntimeException("Product Exception");
        products.add(product);
    }

    @GetMapping()
    public List<Product> greeting() {
        return products;
    }
}
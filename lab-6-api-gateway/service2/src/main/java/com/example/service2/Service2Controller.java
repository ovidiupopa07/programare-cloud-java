package com.example.service2;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class Service2Controller {

    private List<Product> products = new ArrayList<Product>();

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void greeting(@RequestBody Product product, BindingResult result) {
        if(result.hasErrors())
            throw new RuntimeException("Product Exception");
        products.add(product);
    }

    @GetMapping()
    public List<Product> greeting() {
        return products;
    }
}

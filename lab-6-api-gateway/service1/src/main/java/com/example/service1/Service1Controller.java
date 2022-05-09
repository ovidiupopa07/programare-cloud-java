package com.example.service1;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Service1Controller {

    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable String name) {
        System.out.println(name);
        return "Hello " + name + "!";
    }
}

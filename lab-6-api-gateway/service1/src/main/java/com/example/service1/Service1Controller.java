package com.example.service1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class Service1Controller {

    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable String name){
        System.out.println(name);
        return "Hello "+ name;
    }
}

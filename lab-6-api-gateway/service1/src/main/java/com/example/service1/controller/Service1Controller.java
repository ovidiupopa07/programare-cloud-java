package com.example.service1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class Service1Controller {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/greeting/{name}")
    public String greeting(@PathVariable String name, @RequestHeader Map<String, String> headers) {
        System.out.println("Headers:");
        for (Map.Entry<String, String> header : headers.entrySet()) {
            System.out.println(header);
        }
        return String.format("Hello, %s!", name);
    }
}

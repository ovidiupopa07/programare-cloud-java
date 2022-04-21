package com.example.service1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api")
public class Service1Controller {

	@ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/greeting/{name}")
    public String greeting(@PathVariable String name, @RequestHeader Map<String, String> headers) {
		System.out.println("Headers:");
        for(Map.Entry<String,String> header : headers.entrySet()) {
        	System.out.println(header);
        }
        return String.format("Hello %s.", name);
    }
}
package com.example.service1;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Service1Controller {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String list(@RequestHeader Map<String, String> headers) {
        System.out.println("Headers {" + headers + "}");
        return "Hello Brasov";
    }
}

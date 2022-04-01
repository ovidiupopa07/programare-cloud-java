package com.example.circuitbreaker;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class HttpBinService {

    private final RestTemplate rest;

    public HttpBinService(RestTemplate rest) {
        this.rest = rest;
    }

    public Map getWithoutDelay() {
        return rest.getForObject("https://httpbin.org/anything", Map.class);
    }

    public Map getWithDelay(int seconds) {
        return this.rest.getForObject("https://httpbin.org/delay/" + seconds, Map.class);
    }
}
package com.example.circuitbreaker;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CircuitBreakerController.class);

    @Autowired
    private CircuitBreaker countCircuitBreaker;

    @Autowired
    private HttpBinService httpBinService;

    /*
      This method should receive as body an integer which is the numberOfRuns. You need to decorate the circuit breaker using
      a supplier and call the endpoint without delay from HttpBinService.
      Loop through number of runs and fetch the response based on the supplier. If there is an exception, throw 500 error.
      This simulates a number of calls to an endpoint without a delay. Log some messages
    */
    @GetMapping("/no-delay/without-fallback")
    public ResponseEntity<?> noDelayedCall() {
        return ResponseEntity.ok("change me");
    }

    /*
      This method should receive as body an integer which is the numberOfRuns and a path variable which is the delay in seconds
      for the request. You need to decorate the circuit breaker using a supplier and call the endpoint with the delay from HttpBinService.
      Loop through number of runs and fetch the response based on the supplier. If there is an exception, throw 500 error.
      This simulates a number of calls to an endpoint that has a specific delay. Log some messages
    */
    @GetMapping("/delay/with-fallback/{seconds}")
    public ResponseEntity<?> delayedCall() {
        return ResponseEntity.ok("change me");
    }
}

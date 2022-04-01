package com.example.circuitbreaker;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CircuitBreakerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //TODO create an endpoint that has configured a circuit breaker. The endpoint should receive a nrOfRuns(Integer) as argument
    //If the circuit is in closed state it should return 200, else it should throw 500 - internal server error.
    // the circuit breaker should be configured to have:
    // 1) a slowCallRateThreshold of 50
    // 2) a slowCallDurationThreshold of 3 second
    // 3) a slidingWindowSize of 5
    // 4) a sliding window type based on COUNT

    @Test
    public void testCircuitBreakerWithoutDelayShouldReturnOkay() throws Exception {
        this.mockMvc.perform(get("/no-delay/without-fallback")
                        .content(objectMapper.writeValueAsString(3))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/no-delay/without-fallback")
                        .content(objectMapper.writeValueAsString(6))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/no-delay/without-fallback")
                        .content(objectMapper.writeValueAsString(10))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    public void testCircuitBreakerDelay2Seconds6RepeatsShouldReturnOkay() throws Exception {
        this.mockMvc.perform(get("/delay/with-fallback/2")
                        .content(objectMapper.writeValueAsString(6))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    /*
        this method should throw exception because the minimum slidingWindowSize(5) was reached and since slowCallRateThreshold
        is set to 50, it means that 50% of the 5 calls should fail in order to go to open state.
     */
    @Test
    public void testCircuitBreakerDelay4Seconds6RepeatsShouldThrowError() throws Exception {
        this.mockMvc.perform(get("/delay/with-fallback/4")
                        .content(objectMapper.writeValueAsString(6))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isInternalServerError());
    }

    /*
        this method should return okay even though the delay is higher than slowCallDurationThreshold because the minimum
        slidingWindowSize was not reach in order to go in the Open state, so it remains in Closed state
     */
    @Test
    public void testCircuitBreakerDelay4Seconds4RepeatsShouldReturnOkay() throws Exception {
        this.mockMvc.perform(get("/delay/with-fallback/4")
                        .content(objectMapper.writeValueAsString(4))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

}
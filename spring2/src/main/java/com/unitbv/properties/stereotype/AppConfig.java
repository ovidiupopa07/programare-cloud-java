package com.unitbv.properties.stereotype;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
@RequiredArgsConstructor
@ComponentScan
public class AppConfig {
    @Bean
    public Car car() {
        return new Car();
    }
}

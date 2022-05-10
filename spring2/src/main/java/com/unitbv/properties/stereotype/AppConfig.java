package com.unitbv.properties.stereotype;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@RequiredArgsConstructor
@ComponentScan
@PropertySource("classpath:application.properties")
public class AppConfig {
	@Bean
    Car getCar() {
        return new Car();
    }
}

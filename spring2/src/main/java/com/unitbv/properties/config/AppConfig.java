package com.unitbv.properties.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@RequiredArgsConstructor
public class AppConfig {
    @Value("${car.model}")
    private String model;

    @Bean
    public Car setCar(){
        return new Car(model);
    }

}

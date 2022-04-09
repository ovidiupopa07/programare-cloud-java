package com.unitbv.properties.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import com.unitbv.dependsOn.BeanA;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;

@Configuration
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Value("${car.model}")
    private String model;

    @Bean
    public Car car() {
        return new Car(model);
    }
}

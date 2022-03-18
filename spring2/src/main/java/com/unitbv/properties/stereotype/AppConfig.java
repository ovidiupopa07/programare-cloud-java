package com.unitbv.properties.stereotype;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Car car(){
        return new Car();
    }
}

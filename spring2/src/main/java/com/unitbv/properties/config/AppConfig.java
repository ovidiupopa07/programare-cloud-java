package com.unitbv.properties.config;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Autowired
    private Environment environment;


    @Bean
    Car car(){
        return new Car(this.environment.getProperty("car.model"));
    }

}


package com.unitbv.properties.stereotype;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@ComponentScan
public class AppConfig {
    public Car setCar(){
        return new Car();
    }
}

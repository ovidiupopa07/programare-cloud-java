package com.unitbv.properties.config;

import com.unitbv.profiles.programatically.DevDataSourceConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Value("${model}")
    private String model;

    @Bean
    public Car car() {
        return new Car(model);
    }
}

package com.unitbv.properties.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

@Configuration
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Value("${model}")
    private String model;

    @Bean
    public Car car()
    {
        return new Car(this.model);
    }
}

package com.unitbv.properties.programatically;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@RequiredArgsConstructor

public class AppConfig {
    @Value("${model}")
    private String model;

    @Bean
    Car car() {
        return new Car(model);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        Resource[] resources = new ClassPathResource[]
                {new ClassPathResource("application.properties")};
        pspc.setLocations(resources);
        pspc.setIgnoreUnresolvablePlaceholders(true);
        return pspc;
    }
}
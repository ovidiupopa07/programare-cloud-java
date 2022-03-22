package com.unitbv.properties.programatically;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

public class AppConfig {
    @Value("${car.model}")
    private String model;

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propConfigurer = new PropertySourcesPlaceholderConfigurer();
        propConfigurer.setLocation(new ClassPathResource("application.properties"));
        return propConfigurer;
    }

    @Bean
    public Car car() {
        return new Car(model);
    }
}

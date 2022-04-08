package com.unitbv.properties.programatically;

import jdk.internal.loader.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

public class AppConfig {
    @Value("${model}")
    private String model;

    @Bean
    public Car car() {
        return new Car(model);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer pspc
                = new PropertySourcesPlaceholderConfigurer();
        pspc.setLocations(new ClassPathResource[]
                {new ClassPathResource("application.properties")});
        pspc.setIgnoreUnresolvablePlaceholders(true);
        return pspc;
    }
}

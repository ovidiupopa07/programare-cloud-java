package com.unitbv.properties.programatically;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class AppConfig {

    @Value(value = "${model}")
    private String model;


    @Bean
    Car car() {
        return new Car(model);
    }

    @Bean
    static PropertySourcesPlaceholderConfigurer properties() {
        var ppc = new PropertySourcesPlaceholderConfigurer();
        ppc.setLocations(new ClassPathResource("application.properties"));
        ppc.setIgnoreUnresolvablePlaceholders(true);

        return ppc;
    }
}

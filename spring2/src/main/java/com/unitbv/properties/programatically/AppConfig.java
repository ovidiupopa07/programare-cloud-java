package com.unitbv.properties.programatically;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class AppConfig {
    @Value("${car.model}")
    private String model;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer property = new PropertySourcesPlaceholderConfigurer();
        Resource resource = new ClassPathResource("application.properties");
        property.setLocation(resource);
        property.setIgnoreUnresolvablePlaceholders(true);
        return property;
    }

    @Bean
    public Car car() {
        return new Car(model);
    }
}

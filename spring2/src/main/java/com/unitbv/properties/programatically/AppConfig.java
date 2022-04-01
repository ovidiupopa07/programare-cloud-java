package com.unitbv.properties.programatically;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
//import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Value("${car.model}")
    private String model;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySources(){
        PropertySourcesPlaceholderConfigurer ret = new PropertySourcesPlaceholderConfigurer();
        Resource[] resources = new ClassPathResource[ ]
                { new ClassPathResource( "application.properties" ) };
        ret.setLocations(resources);
        ret.setIgnoreUnresolvablePlaceholders(true);
        return ret;
    }


    @Bean
    Car car(){
        return new Car(model);
    }
}


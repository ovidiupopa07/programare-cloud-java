package com.unitbv.events.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

import com.unitbv.events.service.CarService;
import com.unitbv.events.service.PersonService;

@Configuration
public class AppConfig {
    @Bean
    PersonService getPersonService() {
        return new PersonService(new GenericApplicationContext());
    }

    @Bean
    CarService getCarService() {
        return new CarService();
    }
}

package com.unitbv.events.configuration;

import com.unitbv.events.event.CarForRentEvent;
import com.unitbv.events.service.CarService;
import com.unitbv.events.service.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public PersonService personService() {
        return new PersonService(event -> carService().addCarForRent((CarForRentEvent) event));
    }

    @Bean()
    public CarService carService() {
        return new CarService();
    }
}

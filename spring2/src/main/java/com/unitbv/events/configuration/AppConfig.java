package com.unitbv.events.configuration;

import com.unitbv.dependsOn.BeanA;
import com.unitbv.events.event.CarForRentEvent;
import com.unitbv.events.service.CarService;
import com.unitbv.events.service.PersonService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class AppConfig {

    @Bean
    public PersonService personService() {
        return new PersonService(new ApplicationEventPublisher() {
            @Override
            public void publishEvent(Object event) {
                carService().addCarForRent((CarForRentEvent) event);
            }
        });
    }

    @Bean()
    public CarService carService() {
        return new CarService();
    }
}

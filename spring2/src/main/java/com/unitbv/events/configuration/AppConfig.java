package com.unitbv.events.configuration;

import com.unitbv.events.event.CarForRentEvent;
import com.unitbv.events.service.CarService;
import com.unitbv.events.service.PersonService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.unitbv.events"} )
public class AppConfig {
    @Bean
    public CarService carService(){
        return new CarService();
    }

    @Bean
    public PersonService personService(){
        return new PersonService(new ApplicationEventPublisher() {
            @Override
            public void publishEvent(Object event) {
                carService().addCarForRent((CarForRentEvent) event);
            }
        });
    }
}

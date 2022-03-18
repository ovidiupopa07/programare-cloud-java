package com.unitbv.events.service;

import com.unitbv.events.event.CarForRentEvent;
import com.unitbv.events.model.Car;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final ApplicationEventPublisher eventPublisher;

    public PersonService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }


    public void rentCar(String model) {
        //
        System.out.println("Publishing car on event.");
        //
        final Car car = new Car(model);
        //create a new event and publish car on event
        CarForRentEvent event = new CarForRentEvent(car);
        eventPublisher.publishEvent(event);
    }
}

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
        final Car car = new Car(model);
        var event = new CarForRentEvent(car, this);

        eventPublisher.publishEvent(event);
        //create a new event and publish car on event
    }
}

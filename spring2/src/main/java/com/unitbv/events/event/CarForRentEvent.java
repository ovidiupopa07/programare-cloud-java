package com.unitbv.events.event;

import com.unitbv.events.model.Car;
import org.springframework.context.ApplicationEvent;

public class CarForRentEvent extends ApplicationEvent {
    public CarForRentEvent(Car source) {
        super(source);
    }

    public Car getCar()
    {
        return (Car)source;
    }
}

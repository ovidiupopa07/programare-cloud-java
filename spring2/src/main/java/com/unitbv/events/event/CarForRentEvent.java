package com.unitbv.events.event;

import com.unitbv.events.model.Car;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CarForRentEvent extends ApplicationEvent {
    private final Car car;
    
    public CarForRentEvent(Car car, Object source) {
        super(source);
        this.car = car;
    }
    
}

package com.unitbv.events.event;

import com.unitbv.events.model.Car;
import org.springframework.context.ApplicationEvent;
import com.unitbv.events.model.Car;
import lombok.Getter;
@Getter
public class CarForRentEvent extends ApplicationEvent {
    private final Car car;

    public CarForRentEvent(Car car, Object source) {
        super(source);
        this.car = car;
    }
}

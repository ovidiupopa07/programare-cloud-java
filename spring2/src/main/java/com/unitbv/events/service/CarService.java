package com.unitbv.events.service;

import com.unitbv.events.event.CarForRentEvent;
import com.unitbv.events.model.Car;
import lombok.Getter;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class CarService implements ApplicationListener<CarForRentEvent> {
    private final List<Car> availableCars;

    public CarService() {
        this.availableCars = new ArrayList<>();
    }

    public void addCarForRent(CarForRentEvent carForRentEvent) {
        availableCars.add(carForRentEvent.getCar());
    }

    @Override
    public void onApplicationEvent(CarForRentEvent event) {
        this.addCarForRent(event);
    }
}

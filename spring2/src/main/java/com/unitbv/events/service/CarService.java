package com.unitbv.events.service;

import com.unitbv.events.event.CarForRentEvent;
import com.unitbv.events.model.Car;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class CarService {
    private final List<Car> availableCars;

    public CarService() {
        this.availableCars = new ArrayList<>();
    }

    public void addCarForRent(CarForRentEvent carForRentEvent) {
        this.availableCars.add(carForRentEvent.getCar());
    }
}

package com.unitbv.events.service;

import com.unitbv.events.event.CarForRentEvent;
import com.unitbv.events.model.Car;
import lombok.Getter;

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

    @EventListener
    public void addCarForRent(CarForRentEvent carForRentEvent) {
    	Car car = (Car) carForRentEvent.getSource();
    	availableCars.add(car);
    }

	public List<Car> getAvailableCars() {
		return availableCars;
	}
}

package com.unitbv.properties.programatically;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Car {
    private final String model;
    
    public Car(String model) {
    	this.model = model;
    }

	public Object getModel() {
		return model;
	}
}

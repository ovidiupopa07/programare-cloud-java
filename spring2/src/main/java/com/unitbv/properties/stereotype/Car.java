package com.unitbv.properties.stereotype;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;

@Getter
public class Car {
	@Value("${car.model}")
    private String model;
	
	public Car() {
		
	}
    
	public String getModel() {
        return model;
    }

}
package com.unitbv.properties.stereotype;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class Car {
    @Value("${car.model}")
    public String model;

    public Car(String model) {
        //System.out.println("1"+model);
        this.model = model;
        //System.out.println("2"+this.model);
    }

    public String getModel() {
        //System.out.println("3"+model);
        return model;
    }

}
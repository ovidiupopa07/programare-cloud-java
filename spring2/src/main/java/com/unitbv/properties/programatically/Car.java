package com.unitbv.properties.programatically;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Getter
//@RequiredArgsConstructor
@Component
public class Car {
    private String model = null;

    public String getModel() {
        return model;
    }

    public Car(String model) {
        //System.out.println("1"+model);
        this.model = model;
        //System.out.println("2"+model);
    }
}


package com.unitbv.properties.stereotype;


import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertiesStereotypeTest {
    //TODO: define Car as a bean and read model directly in Car.class
    @Test
    public void test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        final Car car = ctx.getBean(Car.class);
        assertEquals(car.getModel(), "Audi");

    }
}

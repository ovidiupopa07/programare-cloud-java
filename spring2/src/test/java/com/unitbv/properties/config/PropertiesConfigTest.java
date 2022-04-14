package com.unitbv.properties.config;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertiesConfigTest {
    // Declare Car as bean in AppConfig; read model value from application.properties file
    @Test
    public void test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        final Car car = ctx.getBean(Car.class);
        assertEquals(car.getModel(), "Audi");

    }
}

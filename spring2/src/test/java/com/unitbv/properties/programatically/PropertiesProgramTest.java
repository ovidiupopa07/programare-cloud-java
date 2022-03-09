package com.unitbv.properties.programatically;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertiesProgramTest {
    //TODO: define Car bean and PropertySourcesPlaceholderConfigurer bean in App config and read model value from application.properties file using PropertySourcesPlaceholderConfigurer; DO NOT USE PropertySource annotation
    @Test
    public void test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        final Car car = ctx.getBean(Car.class);

        assertEquals(car.getModel(), "Audi");

    }
}

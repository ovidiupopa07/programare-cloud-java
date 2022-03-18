package com.unitbv.events.configuration;

import com.unitbv.dependsOn.BeanA;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.unitbv.events")
public class AppConfig {
    public BeanA beanA(){
        return new BeanA();
    }
}

package com.unitbv.dependsOn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class AppConfig {

    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean
    @DependsOn("beanA")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean
    @DependsOn("beanB")
    public BeanC beanC() {
        return new BeanC();
    }
}

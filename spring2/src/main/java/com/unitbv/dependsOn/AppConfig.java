package com.unitbv.dependsOn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class AppConfig {

    @Bean("beanA")
    @DependsOn("beanB")
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean("beanB")
    @DependsOn("beanC")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean("beanC")
    public BeanC beanC() {
        return new BeanC();
    }
}

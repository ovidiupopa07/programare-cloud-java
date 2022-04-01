package com.unitbv.dependsOn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class AppConfig {

    @Bean("beanA")
    @DependsOn("beanB")
    BeanA beanA() {
        return new BeanA();
    }

    @Bean("beanB")
    @DependsOn("beanC")
    BeanB beanB() {
        return new BeanB();
    }

    @Bean("beanC")
    BeanC beanC() {
        return new BeanC();
    }
}

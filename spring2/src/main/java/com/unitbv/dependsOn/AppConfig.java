package com.unitbv.dependsOn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class AppConfig {

    @Bean
    @DependsOn("beanB")
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean
    @DependsOn("beanC")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean
    public BeanC beanC() {
        return new BeanC();
    }


}

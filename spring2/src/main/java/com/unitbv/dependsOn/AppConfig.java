package com.unitbv.dependsOn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "beanA")
    BeanA getBeanA() {
        return new BeanA();
    }

    @Bean(name = "beanB")
    BeanB getBeanB() {
        return new BeanB();
    }

    @Bean(name = "beanC")
    BeanC getBeanC() {
        return new BeanC();
    }
}

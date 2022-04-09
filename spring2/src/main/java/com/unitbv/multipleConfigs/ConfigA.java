package com.unitbv.multipleConfigs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class ConfigA {
    @Bean
    public BeanA beanA() {
        return new BeanA();
    }
}

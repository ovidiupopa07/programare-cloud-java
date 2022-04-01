package com.unitbv.multipleConfigs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigA {
    @Bean(name = "beanA")
    BeanA getBeanA() {
        return new BeanA();
    }
}

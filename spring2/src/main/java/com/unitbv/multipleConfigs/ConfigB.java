package com.unitbv.multipleConfigs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class ConfigB {
    @Bean
    public BeanB beanB() {
        return new BeanB();
    }
}

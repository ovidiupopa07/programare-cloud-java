package com.unitbv.multipleConfigs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigB {
    @Bean
    public BeanB beanB(){return new BeanB();}
}

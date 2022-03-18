package com.unitbv.dependsOn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@ComponentScan("com.unitbv.dependsOn")
public class AppConfig {

    @Bean
    @DependsOn("beanB")
    public BeanA beana(){
        return new BeanA();
    }

    @Bean
    @DependsOn("beanC")
    public BeanB beanB(){
        return new BeanB();
    }

    @Bean
    public BeanC beanC(){
        return new BeanC();
    }
}

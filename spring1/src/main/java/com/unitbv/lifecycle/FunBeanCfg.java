package com.unitbv.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"com.unitbv.lifecycle"})
public class FunBeanCfg {

    @Bean(initMethod = "init" , destroyMethod = "destroy")
    FunBean funBean() {
        return new FunBean();
    }
}

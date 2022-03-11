package com.unitbv.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"com.unitbv.lifecycle"})
public class FunBeanCfg {

    @Bean(initMethod = "onInit", destroyMethod = "onDestroy")
    FunBean funBean() {
        return new FunBean();
    }
}

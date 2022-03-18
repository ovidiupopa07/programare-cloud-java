package com.unitbv.lifecycle;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
@ComponentScan(basePackages = {"com.unitbv.lifecycle"})
public class FunBeanCfg {
    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    FunBean funBean() {
        return new FunBean();
    }
}

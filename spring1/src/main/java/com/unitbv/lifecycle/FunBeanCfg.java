package com.unitbv.lifecycle;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"com.unitbv.lifecycle"})
public class FunBeanCfg {

    FunBean funBean() {
        return new FunBean();
    }
}

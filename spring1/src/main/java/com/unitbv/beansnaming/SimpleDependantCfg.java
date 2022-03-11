package com.unitbv.beansnaming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.unitbv.beansnaming"})
public class SimpleDependantCfg {

    private final Logger logger = LoggerFactory.getLogger(SimpleDependantCfg.class);

    SimpleBean simpleBean() {
        return new SimpleBeanImpl();
    }

    DependantBean dependantBean() {
        return new DependantBeanImpl(simpleBean());
    }
}

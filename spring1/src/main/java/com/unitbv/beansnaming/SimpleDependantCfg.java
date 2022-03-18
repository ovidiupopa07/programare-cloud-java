package com.unitbv.beansnaming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
@Configuration
@ComponentScan(basePackages = {"com.unitbv.beansnaming"})
public class SimpleDependantCfg {

    private final Logger logger = LoggerFactory.getLogger(SimpleDependantCfg.class);

    @Bean(name={"customSimpleBean1","customSimpleBean2"})
    SimpleBean customSimpleBean() {

        @Bean(name = {"customDependantBean1", "customDependantBean2"})
        DependantBean customDependantBean () {
            return (SimpleBean) new DependantBeanImpl(customSimpleBean());
        }
    }
}
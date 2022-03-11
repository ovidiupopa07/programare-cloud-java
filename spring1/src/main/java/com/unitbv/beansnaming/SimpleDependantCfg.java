package com.unitbv.beansnaming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.unitbv.beansnaming"})
public class SimpleDependantCfg {

    private final Logger logger = LoggerFactory.getLogger(SimpleDependantCfg.class);

    @Bean(name = {"customSimpleBean"})
    SimpleBean simpleBean() {
        return new SimpleBeanImpl();
    }
    
//    @Bean(name = {"customSimpleBean"})
//    SimpleBean simpleBean2() {
//        return new SimpleBeanImpl();
//    }

    @Bean(name = {"customDependantBean"})
    DependantBean dependantBean() {
        return new DependantBeanImpl(simpleBean());
    }
    
//    @Bean(name = {"customDependantBean"})
//    DependantBean dependantBean2() {
//        return new DependantBeanImpl(simpleBean());
//    }
    
    @Bean(name = {"customSimpleBean1", "customSimpleBean2"})
    SimpleBean customSimpleBean() {
        return new SimpleBeanImpl();
    }

    @Bean(name = {"customDependantBean1", "customDependantBean2"})
    DependantBean customDependantBean() {
        return new DependantBeanImpl(customSimpleBean());
    }
}

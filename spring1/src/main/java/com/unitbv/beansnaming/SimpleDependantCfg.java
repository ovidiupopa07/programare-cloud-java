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
//
//    @Bean({"simpleBean"})
//    SimpleBean simpleBean() {
//        return new SimpleBeanImpl();
//    }
//
//    @Bean({"dependantBean"})
//    DependantBean dependantBean() {
//        return new DependantBeanImpl(simpleBean());
//    }

//    @Bean({"customSimpleBean"})
//    SimpleBean simpleBean() {
//        return new SimpleBeanImpl();
//    }
//
//    @Bean({"customDependantBean"})
//    DependantBean dependantBean() {
//        return new DependantBeanImpl(simpleBean());
//    }

    @Bean({"customSimpleBean1", "customSimpleBean2"})
    SimpleBean simpleBean() {
        logger.debug("simpleBean!");
        return new SimpleBeanImpl();
    }

    @Bean({"customDependantBean1", "customDependantBean2"})
    DependantBean dependantBean() {
        logger.debug("dependantBean!");
        return new DependantBeanImpl(simpleBean());
    }
}

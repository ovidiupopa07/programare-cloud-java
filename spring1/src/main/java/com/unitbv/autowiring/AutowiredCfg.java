package com.unitbv.autowiring;

import com.unitbv.beansnaming.DependantBean;
import com.unitbv.beansnaming.DependantBeanImpl;
import com.unitbv.beansnaming.SimpleBean;
import com.unitbv.beansnaming.SimpleBeanImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.unitbv.autowiring"})
public class AutowiredCfg {
/*    final SimpleBean simpleBean;
    final DependantBean dependantBean;

    @Autowired
    public AutowiredCfg(SimpleBean simpleBean, DependantBean dependantBean) {
        this.simpleBean = simpleBean;
        this.dependantBean = dependantBean;
    }

    @Bean(name = "simpleBean")
    SimpleBean getSimpleBean() {
        return simpleBean;
    }


    @Bean(name = "dependantBean")
    DependantBean getDependantBean() {
        return dependantBean;
    }*/
}

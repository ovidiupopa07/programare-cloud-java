package com.unitbv.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@ComponentScan(basePackages = {"com.unitbv.lifecycle"})
public class FunBeanCfg {
    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    FunBean funBean() {
        log.info(" constructor funBean() Called");
        return new FunBean();
    }
}

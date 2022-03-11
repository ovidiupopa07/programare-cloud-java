package com.unitbv.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"com.unitbv.lifecycle"})
public class FunBeanCfg {

	private Logger logger = LoggerFactory.getLogger(FunBean.class);
	
	@Bean(initMethod = "onInitialize", destroyMethod = "onDestroy")
    FunBean funBean() {
		logger.info("Bean created");
        return new FunBean();
    }
}

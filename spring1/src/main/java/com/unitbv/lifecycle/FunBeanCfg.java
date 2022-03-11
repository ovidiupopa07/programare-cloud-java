package com.unitbv.lifecycle;

import com.unitbv.beansnaming.SimpleDependantCfg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
@ComponentScan(basePackages = {"com.unitbv.lifecycle"})
public class FunBeanCfg {
	
	@Bean(initMethod = "init", destroyMethod = "destruct")
	FunBean funBean() {
		log.info("funBean() called.");
		return new FunBean();
	}
}

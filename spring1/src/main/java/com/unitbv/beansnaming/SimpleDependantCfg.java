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
	
	@Bean("customSimpleBean2")
	SimpleBean simpleBean() {
		return new SimpleBeanImpl();
	}
	
	@Bean("customDependantBean2")
	DependantBean dependantBean() {
		return new DependantBeanImpl(simpleBean());
	}
	
	@Bean("customSimpleBean1")
	SimpleBean customSimpleBean2() {
		return simpleBean();
	}
	
	@Bean("customDependantBean1")
	DependantBean customDependantBean2() {
		return dependantBean();
	}
}

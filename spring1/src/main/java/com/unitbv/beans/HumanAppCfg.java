package com.unitbv.beans;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.unitbv.beans"} )
@PropertySource("classpath:application.properties")
public class HumanAppCfg {
}

package com.unitbv.autowiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"com.unitbv.autowiring"})
public class AutowiredCfg {
}

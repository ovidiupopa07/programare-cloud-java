package com.unitbv.beans;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.unitbv.beans"} )
@PropertySource("classpath:application.properties")
public class HumanAppCfg {

    public void test() {

    }
}

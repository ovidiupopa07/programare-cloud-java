package com.unitbv.profiles.automatically;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.unitbv.profiles.automatically")
@PropertySource("classpath:profiles.properties")
public class AppConfig {
}

package com.unitbv.profiles.automatically;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:profiles.properties")
@ComponentScan("com.unitbv.profiles.automatically")
public class AppConfig {

}

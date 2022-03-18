package com.unitbv.profiles.automatically;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Calendar;

@Configuration
@ComponentScan
@PropertySource("classpath:profiles.properties")
public class AppConfig {
}
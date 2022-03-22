package com.unitbv.profiles.automatically;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.unitbv.profiles.automatically")
@PropertySource("profiles.properties")
public class AppConfig {

    @Value("${spring.profiles.active}")
    private String str;

    @Bean
    public DataSourceConfig dataSourceConfig() {
        if(this.str.equals("dev")) {
            return new DevDataSourceConfig();
        } else {
            return new ProdDataSourceConfig();
        }
    }
}

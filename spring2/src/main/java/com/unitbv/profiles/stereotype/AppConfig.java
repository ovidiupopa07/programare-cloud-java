package com.unitbv.profiles.stereotype;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.unitbv.profiles.programatically.DevDataSourceConfig;
import org.springframework.context.annotation.Bean;

@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    com.unitbv.profiles.programatically.DevDataSourceConfig devDataSourceConfig() {
        return new DevDataSourceConfig();
    }

    @Bean
    ProdDataSourceConfig prodDataSourceConfig() {
        return new ProdDataSourceConfig();
    }
}

package com.unitbv.profiles.programatically;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.unitbv.profiles.programatically")
public class AppConfig {
    @Bean
    @Profile("dev")
    public DevDataSourceConfig devDataSourceConfig(){
        return new DevDataSourceConfig();
    }

    @Bean
    @Profile("default")
    public DevDataSourceConfig devDataSourceConfigDef(){
        return new DevDataSourceConfig();
    }

    @Bean
    @Profile("prod")
    public ProdDataSourceConfig prodDataSourceConfig(){
        return new ProdDataSourceConfig();
    }
}

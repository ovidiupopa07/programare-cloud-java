package com.unitbv.profiles.programatically;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.unitbv.profiles.programatically")
public class AppConfig {
    @Bean
    @Profile("dev")
    public DevDataSourceConfig devDataSourceConfig(){
        return new DevDataSourceConfig();
    }
    @Bean
    @Profile("prod")
    public ProdDataSourceConfig prodDataSourceConfig(){
        return new ProdDataSourceConfig();
    }

    @Bean
    @Profile(value={"!dev & !prod"})
    public DevDataSourceConfig Default(){
        return new DevDataSourceConfig();
    }
}

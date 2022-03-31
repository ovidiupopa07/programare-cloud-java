package com.unitbv.profiles.programatically;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    @Profile("dev")
    public DataSourceConfig devDataSourceConfig()
    {
        return new DevDataSourceConfig();
    }

    @Bean
    @Profile("default")
    public DataSourceConfig defaultDataSourceConfig()
    {
        return new DevDataSourceConfig();
    }

    @Bean
    @Profile("prod")
    public DataSourceConfig prodDataSourceConfig()
    {
        return new ProdDataSourceConfig();
    }
}

package com.unitbv.profiles.programatically;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.unitbv.profiles.programatically")
@PropertySource("classpath:profiles.properties")
public class AppConfig {
    @Bean
    @Profile({"dev","default"})
    public DevDataSourceConfig devDataSourceConfig()
    {
        return new DevDataSourceConfig();
    }

    @Bean
    @Profile("prod")
    public ProdDataSourceConfig prodDataSourceConfig()
    {
        return new ProdDataSourceConfig();
    }
}

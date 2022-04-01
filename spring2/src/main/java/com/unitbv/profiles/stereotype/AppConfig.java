package com.unitbv.profiles.stereotype;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.unitbv.profiles.stereotype")
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

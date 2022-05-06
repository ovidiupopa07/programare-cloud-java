package com.unitbv.profiles.automatically;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@PropertySource("classpath:profiles.properties")
public class AppConfig {

    @Bean
    @Profile("dev")
    public DevDataSourceConfig devDataSourceConfig()
    {
        return new DevDataSourceConfig();
    }
}

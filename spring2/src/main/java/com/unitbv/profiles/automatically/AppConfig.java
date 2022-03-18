package com.unitbv.profiles.automatically;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.unitbv.profiles.automatically")
@PropertySource("classpath:profiles.properties")
public class AppConfig {

    @Bean
    @Profile("${spring.profile.active}")
    public DevDataSourceConfig devDataSourceConfig()
    {
        return new DevDataSourceConfig();
    }
}
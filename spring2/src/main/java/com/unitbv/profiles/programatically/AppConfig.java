package com.unitbv.profiles.programatically;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.unitbv.profiles.programatically")
@PropertySource("classpath:profiles.properties")
public class AppConfig {
    @Bean
    @Profile("dev")
    DevDataSourceConfig devDataSourceConfig() {
        return new DevDataSourceConfig();
    }

    @Bean
    @Profile("prod")
    ProdDataSourceConfig prodDataSourceConfig() {
        return new ProdDataSourceConfig();
    }

    @Bean
    @Profile("default")
    DevDataSourceConfig dataSourceConfig() {
        return new DevDataSourceConfig();
    }
}

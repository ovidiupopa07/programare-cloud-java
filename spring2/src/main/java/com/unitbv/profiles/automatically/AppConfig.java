package com.unitbv.profiles.automatically;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.unitbv.profiles.automatically")
@PropertySource("classpath:profiles.properties")
public class AppConfig {

    @Bean
    @Profile("dev")
    DevDataSourceConfig dataSourceConfig() {
        return new DevDataSourceConfig();
    }
}

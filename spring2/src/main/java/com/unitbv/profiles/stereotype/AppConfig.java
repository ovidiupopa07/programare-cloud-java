package com.unitbv.profiles.stereotype;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@PropertySource("classpath:profiles.properties")
public class AppConfig {
    @Bean
    @Profile({"default","dev"})
    public DevDataSourceConfig dataSourceConfig(){
        return new DevDataSourceConfig();
    }

    @Bean
    @Profile("prod")
    public ProdDataSourceConfig prodDataSourceConfig(){
        return new ProdDataSourceConfig();
    }
}

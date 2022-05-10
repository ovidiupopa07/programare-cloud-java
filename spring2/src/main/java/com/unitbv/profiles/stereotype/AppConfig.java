package com.unitbv.profiles.stereotype;

import com.unitbv.profiles.programatically.DevDataSourceConfig;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    DevDataSourceConfig devDataSourceConfig()
    {
        return new DevDataSourceConfig();
    }

    @Bean
    ProdDataSourceConfig prodDataSourceConfig()
    {
        return new ProdDataSourceConfig();
    }
}

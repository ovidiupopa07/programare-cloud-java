package com.unitbv.profiles.stereotype;

import com.unitbv.profiles.programatically.DevDataSourceConfig;
import com.unitbv.profiles.programatically.ProdDataSourceConfig;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    @Profile({"dev", "default"})
    public com.unitbv.profiles.programatically.DevDataSourceConfig devDataSourceConfig(){
        return new DevDataSourceConfig();
    }

    @Bean
    @Profile("prod")
    public com.unitbv.profiles.programatically.ProdDataSourceConfig prodDataSourceConfig(){
        return new ProdDataSourceConfig();
    }
}

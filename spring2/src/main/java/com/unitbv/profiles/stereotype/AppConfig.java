package com.unitbv.profiles.stereotype;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class AppConfig {

    public DataSourceConfig devDataSourceConfig() {
        return new DevDataSourceConfig();
    }

    public DataSourceConfig prodDataSourceConfig() {
        return new ProdDataSourceConfig();
    }
}

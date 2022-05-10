package com.unitbv.profiles.automatically;

import org.springframework.stereotype.Component;

@Component
public class ProdDataSourceConfig implements DataSourceConfig {
    @Override
    public void setup() {
        System.out.println("Setting up datasource for PROD environment. ");
    }
}

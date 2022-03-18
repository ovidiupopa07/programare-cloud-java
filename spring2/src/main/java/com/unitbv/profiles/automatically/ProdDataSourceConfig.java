package com.unitbv.profiles.automatically;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("PROD")
public class ProdDataSourceConfig implements DataSourceConfig {
    @Override
    public void setup() {
        System.out.println("Setting up datasource for PROD environment.");
    }
}

package com.unitbv.profiles.stereotype;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdDataSourceConfig implements DataSourceConfig {
    @Override
    public void setup() {

    }
}

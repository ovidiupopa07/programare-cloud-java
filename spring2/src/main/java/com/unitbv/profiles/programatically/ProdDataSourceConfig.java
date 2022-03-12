package com.unitbv.profiles.programatically;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProdDataSourceConfig implements DataSourceConfig {
    @Override
    public void setup() {

    }
}

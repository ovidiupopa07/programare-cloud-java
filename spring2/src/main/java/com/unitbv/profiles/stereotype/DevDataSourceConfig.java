package com.unitbv.profiles.stereotype;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev", "default"})
public class DevDataSourceConfig implements DataSourceConfig {
    @Override
    public void setup() {

    }
}
package com.unitbv.profiles.programatically;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev", "default"})
public class DevDataSourceConfig implements DataSourceConfig {
    @Override
    public void setup() {

    }
}

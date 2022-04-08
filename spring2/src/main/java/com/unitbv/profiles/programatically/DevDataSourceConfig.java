package com.unitbv.profiles.programatically;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("devDataSourceConfig")
@Profile("dev")
public class DevDataSourceConfig implements DataSourceConfig {
    @Override
    public void setup() {
        System.out.println("Setting up datasource for DEV environment. ");
    }
}

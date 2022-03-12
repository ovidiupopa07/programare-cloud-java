package com.unitbv.profiles.automatically;

public class DevDataSourceConfig implements DataSourceConfig {
    @Override
    public void setup() {
        System.out.println("Setting up datasource for DEV environment. ");
    }
}

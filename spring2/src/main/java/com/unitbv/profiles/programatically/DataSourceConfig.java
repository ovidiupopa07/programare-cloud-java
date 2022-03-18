package com.unitbv.profiles.programatically;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

public interface DataSourceConfig {
    public void setup();
}

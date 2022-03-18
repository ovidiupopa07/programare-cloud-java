package com.unitbv.profiles.automatically;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

public interface DataSourceConfig {
    void setup();
}

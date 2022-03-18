package com.unitbv.multipleConfigs.appConfig;

import com.unitbv.multipleConfigs.ConfigA;
import com.unitbv.multipleConfigs.ConfigB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.unitbv.multipleConfigs.appConfig")
@Import({ConfigA.class, ConfigB.class})
public class AppConfig {
}

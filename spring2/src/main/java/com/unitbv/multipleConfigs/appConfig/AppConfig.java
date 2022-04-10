package com.unitbv.multipleConfigs.appConfig;

import com.unitbv.multipleConfigs.ConfigA;
import com.unitbv.multipleConfigs.ConfigB;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ConfigA.class, ConfigB.class})
@ComponentScan(basePackages = "com.unitbv.multipleConfigs.appConfig")
public class AppConfig {

}

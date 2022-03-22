package com.unitbv.multipleConfigs.appConfig;

import com.unitbv.multipleConfigs.BeanB;
import com.unitbv.multipleConfigs.BeanA;
import com.unitbv.multipleConfigs.ConfigA;
import com.unitbv.multipleConfigs.ConfigB;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.unitbv.multipleConfigs.appConfig")
@Import({ ConfigA.class, ConfigB.class })
public class AppConfig {

    private BeanA beanA;
    private BeanB beanB;
}

package com.unitbv.multipleConfigs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigA {

    @Autowired
    BeanA beanA;
}

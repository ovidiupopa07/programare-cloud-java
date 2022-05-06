package com.unitbv.multipleConfigs;

import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanA {

    private BeanB beanB;

    public BeanA(BeanB beanB) {
        this.beanB = beanB;
    }
}

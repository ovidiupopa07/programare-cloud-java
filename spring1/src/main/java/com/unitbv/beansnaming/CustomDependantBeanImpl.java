package com.unitbv.beansnaming;

import org.springframework.stereotype.Component;

@Component
public class CustomDependantBeanImpl implements CustomDependantBean{
    private CustomSimpleBean simpleBean;

    public CustomDependantBeanImpl(CustomSimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }
}

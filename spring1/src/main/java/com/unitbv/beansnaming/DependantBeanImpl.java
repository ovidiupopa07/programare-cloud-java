package com.unitbv.beansnaming;

import org.springframework.stereotype.Component;

@Component("dependantBean")
public class DependantBeanImpl implements DependantBean {
    private SimpleBean simpleBean;

    public DependantBeanImpl(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }
}

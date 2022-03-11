package com.unitbv.beansnaming;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DependantBeanImpl implements DependantBean {
    private SimpleBean simpleBean;

    public DependantBeanImpl(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }
}

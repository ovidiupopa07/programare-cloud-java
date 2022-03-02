package com.unitbv.beansnaming;


public class DependantBeanImpl implements DependantBean {
    private SimpleBean simpleBean;

    public DependantBeanImpl(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }
}

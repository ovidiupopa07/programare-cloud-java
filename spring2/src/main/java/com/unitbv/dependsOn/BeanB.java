package com.unitbv.dependsOn;

import org.springframework.beans.factory.annotation.Autowired;

public class BeanB {
    BeanC beanC;

    public BeanB(BeanC beanC) {
        this.beanC = beanC;
    }
}

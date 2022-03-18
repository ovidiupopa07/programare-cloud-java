package com.unitbv.dependsOn;

import org.springframework.beans.factory.annotation.Autowired;

    public class BeanA {
 BeanB beanB;

    public BeanA(BeanB beanB) {
        this.beanB = beanB;
    }
}

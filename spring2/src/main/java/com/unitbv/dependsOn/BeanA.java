package com.unitbv.dependsOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

    public class BeanA {
    BeanB beanB;

    public BeanA(BeanB beanB) {
        this.beanB = beanB;
    }

}

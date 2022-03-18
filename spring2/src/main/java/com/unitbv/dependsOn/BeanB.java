package com.unitbv.dependsOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


    public class BeanB {
    BeanC beanC;

    public BeanB(BeanC beanC) {
        this.beanC = beanC;
    }
}

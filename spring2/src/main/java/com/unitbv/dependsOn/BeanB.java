package com.unitbv.dependsOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanB {

    @Autowired
    BeanC beanC;
}

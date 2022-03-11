package com.unitbv.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class DepBean implements  InitializingBean, DisposableBean{
    public void afterPropertiesSet() throws Exception {
        System.out.println("Init method interface");
    }

    public void destroy() throws Exception {
        System.out.println("Destroy method interface");
    }
}

package com.unitbv.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class FunBean {
    private final Logger logger = LoggerFactory.getLogger(FunBean.class);

    @Autowired
    DepBean depbean;

    FunBean() { System.out.println("Constructor method"); }

    public void setDepBean(DepBean depBean) {
        this.depbean = depBean;
        System.out.println("Setter injection method");
    }

    @PostConstruct
    public void test() {
        System.out.println("Post construct method");
    }

    @PreDestroy
    public void test2() {
        System.out.println("Pre destroy method");
    }

    public void initMethod() {
        System.out.println("Init method in cfg");
    }

    public void destroyMethod() {
        System.out.println("Destroy method in cfg");
    }
}

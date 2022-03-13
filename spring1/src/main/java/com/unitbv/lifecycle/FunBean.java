package com.unitbv.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class FunBean {
    private Logger logger = LoggerFactory.getLogger(FunBean.class);

    private DepBean depBean;

    @Autowired
    public void setDepBean(DepBean depBean) {
        this.depBean = depBean;
        System.out.println("setter");
    }

    void test(){
        System.out.println("test");
    }

    public FunBean() {
        System.out.println("constructor");
    }

    void testDestroy(){
        System.out.println("destroy");
    }

}

package com.unitbv.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class FunBean implements InitializingBean, DisposableBean {
    private Logger logger = LoggerFactory.getLogger(FunBean.class);

    public FunBean() {
        System.out.println("constructor");
    }

    private DepBean depBean;
    @Autowired
    public void setDepBean(DepBean depBean) {
        System.out.println("setter");
        this.depBean = depBean;
    }

    public void funBean(){
        System.out.println("init");

    }

    public void destroy(){
        System.out.println("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}

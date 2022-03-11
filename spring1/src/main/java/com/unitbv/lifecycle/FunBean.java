package com.unitbv.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class FunBean implements InitializingBean, DisposableBean {

    private final Logger logger = LoggerFactory.getLogger(FunBean.class);

    private DepBean depBean;

    @Autowired
    public void setDepBean(DepBean depBean){
        this.depBean = depBean;
    }

    @PostConstruct
    public void postConstruct() {
        logger.debug("post construct FunBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.debug("after prop set FunBean");
    }

    @Override
    public void destroy() throws Exception {
        logger.debug("destroy FunBean");
    }

    @PreDestroy
    public void preDestroy() {
        logger.debug("preDestroy FunBean");
    }
}

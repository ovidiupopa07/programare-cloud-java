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

    private DepBean depBean;

    @Autowired
    public void setDepBean(DepBean depBean) {
        logger.info("1. Injections");
        this.depBean = depBean;
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("2. Post Construct");
    }

    @Override
    public void afterPropertiesSet() {
        logger.info("3. After properties set");
    }

    public void init() {
        logger.info("4. Init");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("5. Pre destroy");
    }

    @Override
    public void destroy() {
        logger.info("6. Destroy");
    }

    public void finalMethod() {
        logger.info("7. finalMethod");
    }
}

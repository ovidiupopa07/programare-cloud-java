package com.unitbv.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class FunBean implements InitializingBean, DisposableBean, ApplicationContextAware {
    private Logger logger = LoggerFactory.getLogger(FunBean.class);

    private DepBean depBean;

    @Autowired
    public void setDepBean(DepBean depBean) {
        logger.info("Set Dep Bean");
        this.depBean = depBean;
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("Bean post construct");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("Bean post destroy");
    }

    public void onInit() {
        logger.info("Bean initMethod");
    }

    public void onDestroy() {
        logger.info("Bean destroyMethod");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("Bean after properties set");
    }

    @Override
    public void destroy() throws Exception {
        logger.info("Bean destroyed");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("Bean set application context");
    }
}

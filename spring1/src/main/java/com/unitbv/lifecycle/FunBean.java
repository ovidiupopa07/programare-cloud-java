package com.unitbv.lifecycle;

import com.unitbv.beans.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class FunBean implements InitializingBean, DisposableBean, ApplicationContextAware {

    private Logger logger = LoggerFactory.getLogger(FunBean.class);

    @Autowired
    private DepBean depBean;

    @Autowired
    public FunBean() {

    }

    @Autowired
    void setDepBean(DepBean depBean) {
        this.depBean = depBean;
        logger.debug("[Setter]");
    }

    @Override
    public void destroy() throws Exception {
        logger.debug("[DestroyOverride]");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.debug("[afterPropertiesSet]");
    }

    public void initializeMethod() {
        logger.debug("[Initialize]");
    }

    public void destroyMethod() {
        logger.debug("[Destroy]");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.debug("[setApplicationContext]");
    }

    @PostConstruct
    public void postConstruct() {
        logger.debug("[PostConstruct]");
    }

    @PreDestroy
    public void preDestroy() {
        logger.debug("[PreDestroy]");
    }
}
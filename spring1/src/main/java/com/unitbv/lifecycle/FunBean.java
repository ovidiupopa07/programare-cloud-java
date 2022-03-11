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
public class FunBean implements InitializingBean, DisposableBean{
    private Logger logger = LoggerFactory.getLogger(FunBean.class);

    private DepBean depBean;

    @Autowired
    public void setDepBean(DepBean depBean) {
        this.depBean = depBean;
        logger.debug("depBean set!");
    }

    public void initMethod() {
        logger.debug("initMethod!");
    }

    public void destroyMethod() {
        logger.debug("destroyMethod!");
    }

    @PreDestroy
    public void destroy() throws Exception {
        logger.debug("destroy!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.debug("afterPropertiesSet!");
    }
}

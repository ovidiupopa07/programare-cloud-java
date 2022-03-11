package com.unitbv.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FunBean implements InitializingBean, DisposableBean {
    private DepBean depBean;
    final private Logger logger = LoggerFactory.getLogger(FunBean.class);

    public FunBean() {
        logger.info("Fun Bean empty constructor ");
    }

    @Autowired
    public FunBean(DepBean depBean) {
        this.depBean = depBean;
        logger.info("Fun Bean parameter constructor ");
    }

    public void setDepBean(DepBean depBean) {
        this.depBean = depBean;
    }

    public void initMethod() {
        logger.info("init method");
    }

    public void destroyMethod() {
        logger.info("destroy method");
    }

    @Override
    public void destroy() throws Exception {
        logger.info("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("after Properties Set");
    }
}

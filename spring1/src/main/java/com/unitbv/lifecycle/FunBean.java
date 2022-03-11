package com.unitbv.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.beans.BeanProperty;

public class FunBean implements InitializingBean, DisposableBean {
    private Logger logger = LoggerFactory.getLogger(FunBean.class);

    private DepBean depBean;

    @Autowired
    public void setDepBean(DepBean depBean) {
        this.depBean = depBean;
    }

    @Override
    public void destroy() throws Exception {
        logger.info("destroy Called.");

        depBean.setDepAttribute("destroy DepBean");
        logger.info(depBean.getDepAttribute());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("afterPropertiesSet Called.");

        depBean.setDepAttribute("afterPropertiesSet DepBean");
        logger.info(depBean.getDepAttribute());
    }

    public void initMethod() {
        logger.info("initMethod Called.");

        depBean.setDepAttribute("Hello DepBean!");
        logger.info(depBean.getDepAttribute());
    }

    public void destroyMethod() {
        logger.info("destryoMethod Called.");

        depBean.setDepAttribute("Goodbye DepBean!");
        logger.info(depBean.getDepAttribute());
    }
}

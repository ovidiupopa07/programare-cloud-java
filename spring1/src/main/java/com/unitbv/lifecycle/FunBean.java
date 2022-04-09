package com.unitbv.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class FunBean implements InitializingBean, DisposableBean, ApplicationContextAware {    private Logger logger = LoggerFactory.getLogger(FunBean.class);

    private DepBean depBean;

    @Autowired
    public void setDepBean(DepBean depBean) {
        this.depBean = depBean;
        logger.info("depBean injected");
    }

    @Bean(initMethod="init")
    public void initMethod(){
        logger.info("@Bean init method");
    }

    @Bean(destroyMethod = "destroy")
    public void destroyMethod(){
        logger.info("@Bean destroy method");
    }

    @Override
    public void destroy() throws Exception {
        logger.info("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("after properties");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("set application context");
    }

    @PostConstruct
    public void customInit()
    {
        logger.info("custom init");
    }

    @PreDestroy
    public void customDestroy()
    {
        logger.info("custom destroy");
    }
}

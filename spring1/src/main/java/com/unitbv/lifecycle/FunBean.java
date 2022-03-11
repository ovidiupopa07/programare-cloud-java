package com.unitbv.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class FunBean implements InitializingBean, DisposableBean{
    private Logger logger = LoggerFactory.getLogger(FunBean.class);

    private DepBean depBean;
    
    @Autowired
    public void setDepBean(DepBean depBean) {
    	this.depBean = depBean;
    	logger.info("DepBean has been set");
    }
    
    @PostConstruct
    public void postConstruct() {
    	logger.info("Post construct called");
    }
    
    @PreDestroy
    public void preDestroy() {
    	logger.info("Pre destroy called");
    }

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("After properties set called");
	}

	@Override
	public void destroy() throws Exception {
		logger.info("FunBean destroyed");
	}
	
	public void onInitialize() {
		logger.info("onInitialize called");
	}
	
	public void onDestroy() {
		logger.info("onDestroy called");
	}
}

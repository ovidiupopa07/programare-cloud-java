package com.unitbv.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class FunBean implements InitializingBean, DisposableBean {
	
	private DepBean depBean;
	
	@Autowired
	public void setDepBean(DepBean depBean) {
		log.info("setDepBean");
		this.depBean = depBean;
	}
	
	public FunBean() {
		log.info("constructor funBean");
	}
	
	@Override
	public void destroy() throws Exception {
		log.info("destroy called in funBean");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("afterPropertiesSet called in funBean");
	}
	
	public void init() {
		log.info("init called in funBean");
	}
	
	public void destruct() {
		log.info("destruct called in funBean");
	}
	
}

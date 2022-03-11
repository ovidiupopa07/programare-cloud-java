package com.unitbv.beansnaming;

import org.springframework.stereotype.Component;

public class DependantBeanImpl implements DependantBean {
	private final SimpleBean simpleBean;
	
	public DependantBeanImpl(SimpleBean simpleBean) {
		this.simpleBean = simpleBean;
	}
}

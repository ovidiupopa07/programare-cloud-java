package com.unitbv.dependsOn;

import org.springframework.stereotype.Component;

@Component
public class BeanA {
	private BeanB beanB;
	
	public BeanA(BeanB beanB) {
		this.beanB = beanB;
	}
}

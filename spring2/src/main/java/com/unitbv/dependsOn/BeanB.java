package com.unitbv.dependsOn;

import org.springframework.stereotype.Component;

@Component
public class BeanB {
	private BeanC beanC;
	
	public BeanB(BeanC beanC) {
		this.beanC = beanC;
	}
}

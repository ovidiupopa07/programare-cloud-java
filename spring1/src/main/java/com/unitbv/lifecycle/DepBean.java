package com.unitbv.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DepBean {
	DepBean(){
		log.info("DepBean constructor");
	}
	
}

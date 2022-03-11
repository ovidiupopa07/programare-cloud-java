package com.unitbv.stereotype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.unitbv.stereotype.controller.UserController;
import com.unitbv.stereotype.model.User;
import com.unitbv.stereotype.repository.impl.UserRepositoryImpl;
import com.unitbv.stereotype.service.impl.UserServiceImpl;
import com.unitbv.stereotype.util.UserUtil;

@Configuration
@ComponentScan(basePackages = "com.unitbv")
public class StereotypeCfg {
	@Bean
	public UserUtil userUtil() {
		return new UserUtil();
	}
	
	@Bean
	public UserRepositoryImpl userRepositoryImpl() {
		return new UserRepositoryImpl();
	}
	
	@Bean
	public UserServiceImpl userServiceImpl() {
		return new UserServiceImpl();
	}
	
	@Bean
	public UserController userController() {
		return new UserController();
	}
	
	@Bean
	public User user() {
		return new User();
	}
}

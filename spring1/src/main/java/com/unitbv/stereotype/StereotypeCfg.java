package com.unitbv.stereotype;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.unitbv.stereotype.service.UserService;
import com.unitbv.stereotype.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
@Configuration
@ComponentScan(basePackages = "com.unitbv")
public class StereotypeCfg {
}

package com.unitbv.stereotype;

import com.unitbv.stereotype.controller.UserController;
import com.unitbv.stereotype.repository.UserRepository;
import com.unitbv.stereotype.service.UserService;
import com.unitbv.stereotype.util.UserUtil;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.unitbv.stereotype")

public class StereotypeCfg {
}

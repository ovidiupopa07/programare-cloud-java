package com.unitbv.stereotype;

import com.unitbv.stereotype.controller.UserController;
import com.unitbv.stereotype.repository.UserRepository;
import com.unitbv.stereotype.repository.impl.UserRepositoryImpl;
import com.unitbv.stereotype.service.UserService;
import com.unitbv.stereotype.service.impl.UserServiceImpl;
import com.unitbv.stereotype.util.UserUtil;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StereotypeCfgTest {

    //TODO add stereotype annotations in order to instantiate the beans. Use more specific annotations where you can
    // Hint 1: there are 4 stereotype annotations
    // Hint 2: pay attention to the configuration of StereotypeCfg.class
    @Test
    void testStereotypeAnnotations() {
        var ctx = new AnnotationConfigApplicationContext(StereotypeCfg.class);
        ctx.registerShutdownHook();

        UserController userControllerBean = ctx.getBean(UserController.class);
        UserService userServiceBean = ctx.getBean(UserServiceImpl.class);
        UserRepository userRepositoryBean = ctx.getBean(UserRepositoryImpl.class);
        UserUtil userUtilBean = ctx.getBean(UserUtil.class);

        assertNotNull(userControllerBean);
        assertNotNull(userServiceBean);
        assertNotNull(userRepositoryBean);
        assertNotNull(userUtilBean);

    }
}

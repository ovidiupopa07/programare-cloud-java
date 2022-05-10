package com.unitbv.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FunBeanCfgTest {

    @Test
    void testBeanLifecycle() {
        //TODO configure all lifecycle methods for FunBean and log messages just to be clear in each order are the methods called.
        // hint 1: Use setter to inject a value for DepBean
        // hint 2: @Bean has 2 values called initMethod and destroyMethod
        // hint 3: you need to implement InitializingBean, DisposableBean
        // hint 4: there should be 8 logged messages
        var ctx = new AnnotationConfigApplicationContext(FunBeanCfg.class);
        ctx.registerShutdownHook();

        FunBean funBean = ctx.getBean(FunBean.class);
        assertNotNull(funBean);
    }
}

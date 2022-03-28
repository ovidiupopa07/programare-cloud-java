package com.unitbv.multipleConfigs;


import com.unitbv.multipleConfigs.appConfig.AppConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MultipleConfigsTest {
        // TODO: create 2 classes: BeanA, BeanB and declare them as beans in 2 config class; use both of them in AppConfig class
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        BeanA beanA = context.getBean("beanA", BeanA.class);
        BeanB beanB = context.getBean("beanB", BeanB.class);

        assertNotNull(beanA);
        assertNotNull(beanB);

        context.close();

    }
}

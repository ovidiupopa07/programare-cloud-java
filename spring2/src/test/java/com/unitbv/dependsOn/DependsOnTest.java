package com.unitbv.dependsOn;


import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DependsOnTest {
    // TODO: cmake them depending on each other like:
    // BeanA depends on BeanB and BeanB depends on BeanCreate 3 beans: BeanA, BeanB and BeanC and
    // use configuration class to declare beans
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        BeanA beanA = context.getBean("beanA", BeanA.class);
        BeanB beanB = context.getBean("beanB", BeanB.class);
        BeanC beanC = context.getBean("beanC", BeanC.class);

        assertNotNull(beanA);
        assertNotNull(beanB);
        assertNotNull(beanC);
        context.close();

    }
}

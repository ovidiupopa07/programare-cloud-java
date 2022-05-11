package com.unitbv.beansnaming;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleDependantCfgTest {

    @Test
    void testBeanNamingDefaultName() {
        //TODO create definitions for SimpleBean and DependantBean and log some messages
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(SimpleDependantCfg.class);

        SimpleBean simpleBean = ctx.getBean("simpleBean", SimpleBean.class);
        DependantBean dependantBean = ctx.getBean("dependantBean", DependantBean.class);

        assertNotNull(simpleBean);
        assertNotNull(dependantBean);

        ctx.close();
    }

    @Test
    void testBeanNamingSingleCustomName() {
        //TODO define a name for your beans
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(SimpleDependantCfg.class);

        SimpleBean customSimpleBean = ctx.getBean("customSimpleBean", SimpleBean.class);
        DependantBean customDependantBean = ctx.getBean("customDependantBean", DependantBean.class);

        assertNotNull(customSimpleBean);
        assertNotNull(customDependantBean);

        // no bean named 'simpleBean' and 'dependantBean'
        assertThrows(NoSuchBeanDefinitionException.class, () -> ctx.getBean("simpleBean", SimpleBean.class));
        assertThrows(NoSuchBeanDefinitionException.class, () -> ctx.getBean("dependantBean", DependantBean.class));

        ctx.close();
    }

    @Test
    void testBeanNamingMultipleCustomName() {
        //TODO define multiple names for the same bean
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(SimpleDependantCfg.class);

        SimpleBean customSimpleBean1 = ctx.getBean("customSimpleBean1", SimpleBean.class);
        SimpleBean customSimpleBean2 = ctx.getBean("customSimpleBean2", SimpleBean.class);

        DependantBean customDependantBean1 = ctx.getBean("customDependantBean1", DependantBean.class);
        DependantBean customDependantBean2 = ctx.getBean("customDependantBean2", DependantBean.class);

        assertNotNull(customSimpleBean1);
        assertNotNull(customSimpleBean2);
        assertEquals(customDependantBean1, customDependantBean2);

        assertNotNull(customDependantBean1);
        assertNotNull(customDependantBean2);
        assertEquals(customDependantBean1, customDependantBean2);

        ctx.close();
    }
}

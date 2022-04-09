package com.unitbv.autowiring;

import com.unitbv.autowiring.service.FormatServiceConstructorInjection;
import com.unitbv.autowiring.service.FormatServiceFieldInjection;
import com.unitbv.autowiring.service.FormatServiceSetterInjection;
import com.unitbv.autowiring.util.FormatUtil;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AutowiredCfgTest {
    //TODO use constructor injection, setter injection and field injection to add dependency in FormatServices classes

    @Test
    void checkFormattedTestAutowireConstructorInjection() {
        FormatUtil formatUtil = new FormatUtil();
        FormatServiceConstructorInjection formatServiceConstructorInjection = new FormatServiceConstructorInjection(formatUtil);
        formatServiceConstructorInjection.checkFormatted();
    }

    @Test
    void checkFormattedTestAutowireSetterInjection() {
        FormatUtil formatUtil = new FormatUtil();
        FormatServiceSetterInjection formatServiceSetterInjection = new FormatServiceSetterInjection();
        formatServiceSetterInjection.setFormatUtil(formatUtil);
        formatServiceSetterInjection.checkFormatted();
    }

    @Test
    void checkFormattedTestAutowireFieldInjection() {
        ConfigurableApplicationContext ctx =
                new AnnotationConfigApplicationContext(AutowiredCfg.class);
        FormatServiceFieldInjection formatServiceFieldInjection = ctx.getBean(FormatServiceFieldInjection.class);
        assertNotNull(formatServiceFieldInjection);
        formatServiceFieldInjection.checkFormatted();
    }
}

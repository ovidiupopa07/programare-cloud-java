package com.unitbv.profiles.programatically;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

//TODO: define 3 beans in AppConfig, one for each profile: dev, default, prod
public class ProfilesTest {
    @Test
    public void devProfile() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("dev");
        ctx.register(AppConfig.class);
        ctx.refresh();
        assertInstanceOf(DevDataSourceConfig.class, ctx.getBean(DataSourceConfig.class));
    }

    @Test
    public void prodProfile() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("prod");
        ctx.register(AppConfig.class);
        ctx.refresh();

        assertInstanceOf(ProdDataSourceConfig.class, ctx.getBean(DataSourceConfig.class));
    }

    @Test
    public void defaultProfile() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        assertInstanceOf(DevDataSourceConfig.class, ctx.getBean(DataSourceConfig.class));
    }

}

package com.unitbv.profiles.stereotype;

import com.unitbv.profiles.programatically.AppConfig;
import com.unitbv.profiles.programatically.DataSourceConfig;
import com.unitbv.profiles.programatically.DevDataSourceConfig;
import com.unitbv.profiles.programatically.ProdDataSourceConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

//TODO define DevDataSourceConfig and ProdDataSourceConfig as beans and set profiles: dev and default for DevDataSourceConfig and prod for ProdDataSourceConfig
public class ProfilesTest {
    @Test
    public void devProfile() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("dev");
        ctx.register(com.unitbv.profiles.programatically.AppConfig.class);
        ctx.refresh();
        assertInstanceOf(DevDataSourceConfig.class, ctx.getBean(DataSourceConfig.class));
    }

    @Test
    public void prodProfile() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("prod");
        ctx.register(com.unitbv.profiles.programatically.AppConfig.class);
        ctx.refresh();

        assertInstanceOf(ProdDataSourceConfig.class, ctx.getBean(com.unitbv.profiles.programatically.DataSourceConfig.class));
    }

    @Test
    public void defaultProfile() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        assertInstanceOf(DevDataSourceConfig.class, ctx.getBean(DataSourceConfig.class));
    }

}

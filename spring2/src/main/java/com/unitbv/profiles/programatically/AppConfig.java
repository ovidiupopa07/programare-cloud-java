package com.unitbv.profiles.programatically;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Service;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Service
@Configuration
public class AppConfig {
/*    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter(
                "spring.profiles.active", "dev");
    }*/

    @Bean
    @Profile("default")
    public DataSourceConfig getDataSourceConfig() {
        return new DevDataSourceConfig();
    }

    @Bean
    @Profile("dev")
    public DevDataSourceConfig getDevDataSourceConfig() {
        return new DevDataSourceConfig();
    }

    @Bean
    @Profile("prod")
    public ProdDataSourceConfig getProdDataSourceConfig() {
        return new ProdDataSourceConfig();
    }
}

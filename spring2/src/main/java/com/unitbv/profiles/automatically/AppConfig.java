package com.unitbv.profiles.automatically;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;

@Configuration
@ComponentScan
@PropertySource("classpath:profiles.properties")
public class AppConfig {
	@Bean
    @ConditionalOnExpression("'${spring.profiles.active}'.equalsIgnoreCase('DEV')")
    public DevDataSourceConfig createDevBean() {
        return new DevDataSourceConfig();
    }

    @Bean
    @ConditionalOnExpression("'${spring.profiles.active}'.equalsIgnoreCase('PROD')")
    public ProdDataSourceConfig createProdBean() {
        return new ProdDataSourceConfig();
    }
}

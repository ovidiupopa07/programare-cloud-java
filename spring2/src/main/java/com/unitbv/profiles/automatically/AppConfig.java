package com.unitbv.profiles.automatically;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.*;

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

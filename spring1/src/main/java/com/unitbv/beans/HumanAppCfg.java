package com.unitbv.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.unitbv.beans"} )
public class HumanAppCfg {

    @Bean
    public Book bookBean(){
        return new Book("");
    }

    @Bean
    public Person humanBean(Book book){
        return new Person(book);
    }
}

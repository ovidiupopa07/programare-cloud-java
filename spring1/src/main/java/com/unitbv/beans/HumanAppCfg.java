package com.unitbv.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.unitbv.beans"} )
@PropertySource("application.properties")
public class HumanAppCfg {
    @Value( "${book.title}" )
    String title;

    @Bean
    Book book(){
        return new Book(title);
    }

    @Bean
    Person person (Book book){
        return new Person(book);
    }
}

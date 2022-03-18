package com.unitbv.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.unitbv.beans"} )
public class HumanAppCfg {
    @Bean
    public Book book(){
        return new Book("laborator 2");
    }

    @Bean
    public Person person(Book book){
        return new Person(book);
    }
}

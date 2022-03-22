package com.unitbv.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = {"com.unitbv.beans"} )
public class HumanAppCfg {

    @Value("${book.title}")
    private String bookTitle;

    @Bean
    public Person person(Item item) {
        return new Person(item);
    }

    @Bean
    public Book book() {
        return new Book(bookTitle);
    }
}

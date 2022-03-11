package com.unitbv.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = {"com.unitbv.beans"} )
public class HumanAppCfg {
    /*
     * I tried to access the book title trough two options
     * Via member and via constructor, somehow I only get the string as is it: ${book.title}
     * Although the test HumanAppCfgTest run successfully, the last test will not run if I uncomment one
     * variant or the other.
     */
    //@Value("${book.title}")
    public String prop = "Dummy title";

    /*@Autowired
    public HumanAppCfg(@Value("${book.title}") String prop) {
        this.prop = prop;
    }*/

    @Bean
    public Human getHuman(){
        Person person = new Person();
        person.setItem(new Book(this.prop));
        return person;
    }
}

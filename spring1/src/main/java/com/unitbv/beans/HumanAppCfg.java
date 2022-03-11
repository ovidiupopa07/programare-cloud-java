package com.unitbv.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.unitbv.beans"} )
@PropertySource("classpath:application.properties")
public class HumanAppCfg {
	@Value("${<book.title>}")
	private String bookTitle;
	
	@Bean
	public Book book() {
		return new Book(bookTitle);
	}
	
	@Bean
	public Person person() {
		return new Person(book());
	}
}

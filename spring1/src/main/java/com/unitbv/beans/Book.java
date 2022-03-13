package com.unitbv.beans;

import com.unitbv.lifecycle.FunBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource(value = { "classpath:application.properties" })
public class Book implements Item {

    private String title;

    private Logger logger = LoggerFactory.getLogger(FunBean.class);

    public Book(@Value("${book.title}") String title ){
        logger.info("[title="+ title+"]");
        this.title=title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}

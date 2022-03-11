package com.unitbv.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component

public class Book implements Item {

    private String title;

    public Book(String title) {
    	this.title=title;
    }
    
    @Override
    public String getTitle() {
        return title;
    }
}

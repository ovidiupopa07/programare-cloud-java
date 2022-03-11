package com.unitbv.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Book implements Item {
	
	@Autowired
	public Book(String title) {
		this.title = title;
	}

    private String title;

    @Override
    public String getTitle() {
        return title;
    }
}

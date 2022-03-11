package com.unitbv.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component

public class Book implements Item {
	
	private String title;
	
	@Override
	public String getTitle() {
		return title;
	}
	
	@Autowired
	public void setTitle(String title) {
		this.title = title;
	}
}

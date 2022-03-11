package com.unitbv.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person implements Human {
	
	@Autowired
	public Person(Item book) {
		this.item = book;
	}

    private Item item;

    @Override
    public Item getItem() {
        return item;
    }
}

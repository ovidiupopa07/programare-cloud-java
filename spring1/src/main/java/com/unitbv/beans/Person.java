package com.unitbv.beans;

import org.springframework.stereotype.Component;

@Component
public class Person implements Human {

    private Item item;

    public Person(Item book) {
    	item = book;
    }
    
    @Override
    public Item getItem() {
        return item;
    }
}

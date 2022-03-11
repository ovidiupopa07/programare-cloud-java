package com.unitbv.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person implements Human {

    private Item item;

    @Autowired
    public Person(Item item) {
        this.item = item;
    }

    @Override
    public Item getItem() {
        return item;
    }
}

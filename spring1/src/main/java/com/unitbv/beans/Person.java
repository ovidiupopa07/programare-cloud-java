package com.unitbv.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


public class Person implements Human {

    private Item item;

    public Person(Item item){
        this.item=item;
    }

    @Override
    public Item getItem() {
        return item;
    }
}

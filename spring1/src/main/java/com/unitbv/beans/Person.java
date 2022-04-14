package com.unitbv.beans;

import com.unitbv.autowiring.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Person implements Human {

    @Autowired
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

package com.unitbv.beans;

import org.springframework.stereotype.Component;

@Component
public class Person implements Human
{

    private Item item;
    private final Item item;

    public Person(Item item)
    {
        this.item = item;
    }

    @Override
    public Item getItem()
    {
        return item;
    }
}
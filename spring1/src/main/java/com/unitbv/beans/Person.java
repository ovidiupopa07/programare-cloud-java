package com.unitbv.beans;

public class Person implements Human {

    private Item item;

    public Person(Item item) {
        this.item = item;
    }
    @Override
    public Item getItem() {
        return item;
    }
}

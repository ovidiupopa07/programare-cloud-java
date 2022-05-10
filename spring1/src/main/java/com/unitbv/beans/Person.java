package com.unitbv.beans;

public class Person implements Human {

    private Item item;

    @Override
    public Item getItem() {
        return item;
    }
}

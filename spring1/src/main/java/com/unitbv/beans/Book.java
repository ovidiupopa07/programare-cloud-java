package com.unitbv.beans;

public class Book implements Item {

    private String title;

    @Override
    public String getTitle() {
        return title;
    }
}

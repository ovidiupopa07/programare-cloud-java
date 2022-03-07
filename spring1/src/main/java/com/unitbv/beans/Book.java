package com.unitbv.beans;

public class Book implements Item {

    private String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}

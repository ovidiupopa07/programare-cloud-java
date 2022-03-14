package com.unitbv.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Book implements Item {

    private String title;

    @Autowired
    public Book(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}

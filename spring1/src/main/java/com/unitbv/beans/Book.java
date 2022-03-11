package com.unitbv.beans;

import com.unitbv.autowiring.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;

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

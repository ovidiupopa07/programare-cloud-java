
package com.unitbv.beans;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Book implements Item {

    private String title;


    public Book(){
        this.title = "title";
    }

    @Override
    public String getTitle() {
        return title;
    }
}

package com.unitbv.beans;

import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@AllArgsConstructor
public class Book implements Item {
    @Getter @Setter
    private String title;

    @Override
    public String getTitle() {
        return title;
    }
}

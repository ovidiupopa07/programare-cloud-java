package com.unitbv.beans;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
public class Person implements Human {
    @Getter @Setter
    private Item item;

    @Override
    public Item getItem() {
        return item;
    }
}

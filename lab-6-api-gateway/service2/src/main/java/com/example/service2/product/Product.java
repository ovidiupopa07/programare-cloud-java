package com.example.service2.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @NotNull
    @Column(nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(nullable = false, unique = true)
    private int quantity;
}

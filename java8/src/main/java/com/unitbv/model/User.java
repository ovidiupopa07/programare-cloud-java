package com.unitbv.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String job;
}

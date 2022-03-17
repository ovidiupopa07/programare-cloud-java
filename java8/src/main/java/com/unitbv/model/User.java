package com.unitbv.model;

import lombok.*;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String job;

    public User(int id, String firstName, String lastName, int age, String job) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.job = job;
    }

    public User() {
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.job = "";
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;

        return this.id == user.id &&
                this.firstName.equals(user.firstName) &&
                this.lastName.equals(user.lastName) &&
                this.age == user.age &&
                this.job.equals(user.job);
    }
}
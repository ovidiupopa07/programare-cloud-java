package com.eureka.persons.services;

import com.eureka.persons.person.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> findAll();

    Optional<Person> findById(Long id);

    Person save(Person person);

    void delete(Person person);
}
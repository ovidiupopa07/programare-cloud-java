package com.eureka.persons;

import com.eureka.persons.ex.NotFoundException;
import com.eureka.persons.person.Person;
import com.eureka.persons.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonsController {
    private PersonService personService;

    public PersonsController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Handles requests to list all persons.
     */
    //TODO find all persons using the functions already implemented and sort them by id
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> list() {

        return personService.findAll();
    }

    /**
     * Handles requests to create a person.
     */
    //TODO save a person to the db or throw PersonsException
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody Person person, BindingResult result) {
        if(result.hasErrors())
            throw new PersonsException(HttpStatus.BAD_REQUEST, "Persons Exception");
        personService.save(person);
    }

    /**
     * Returns the {@code Person} instance with id {@code id}
     *
     * @param id
     * @return
     */
    //TODO find a person by id or throw NotFoundException
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person show(@PathVariable Long id) {

        return personService.findById(id).orElseThrow(()->new NotFoundException(Person.class,id));
    }

    /**
     * Updates the {@code Person} instance with id {@code id}
     *
     * @param updatedPerson
     * @param id
     * @return
     */
    //TODO update an existing person if found else throw NotFoundException
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Person updatedPerson, @PathVariable Long id) {
        Person result = personService.findById(id).orElseThrow(()->new NotFoundException(Person.class,id));
        result.setFirstName(updatedPerson.getFirstName());
        result.setLastName(updatedPerson.getLastName());
        result.setPassword(updatedPerson.getPassword());
        result.setHiringDate(updatedPerson.getHiringDate());
        result.setNewPassword(updatedPerson.getNewPassword());
        result.setUsername(updatedPerson.getUsername());
        personService.save(result);
    }

    /**
     * Delete the {@code Person} instance with id {@code id}
     *
     * @param id
     */
    //TODO delete a person
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personService.delete(personService.findById(id).orElseThrow(()->new NotFoundException(Person.class,id)));
    }
}
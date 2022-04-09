package com.eureka.persons;

import com.eureka.persons.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

    @Query("select p from Person p where p.username like %?1%")
    Optional<Person> findByUsername(String username);

    @Query("select p from Person p where p.username like %?1%")
    List<Person> findByUsernameLike(String username);

    @Query("select p from Person p where p.firstName=:fn")
    List<Person> findByFirstName(@Param("fn") String firstName);

    @Query("select p from Person p where p.firstName like %?1%")
    List<Person> findByFirstNameLike(String firstName);

    @Query("select p from Person p where p.lastName=:ln")
    List<Person> findByLastName(@Param("ln") String lastName);

    @Query("select p from Person p where p.lastName like %?1%")
    List<Person> findByLastNameLike(String lastName);

    @Query("select p from Person p where p.hiringDate=:hd")
    List<Person> findByHiringDate(@Param("hd") LocalDateTime date);
}


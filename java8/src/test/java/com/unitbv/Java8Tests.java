package com.unitbv;

import com.unitbv.datasource.UserDataSource;
import com.unitbv.model.User;
import com.unitbv.util.DateTimeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Tests {
    private UserDataSource dataSource;

    @BeforeEach
    public void setup(){
        dataSource = new UserDataSource(Stream.of(
                new User(1, "John", "Wick", 35, "actor"),
                new User(2, "Jayce", "Lucas", 35, "driver"),
                new User(3, "Jack", "Spades", 18, "gamer"),
                new User(4, "Doug", "Rain", 55, "chef"),
                new User(5, "Lena", "Sunday", 12, "student"),
                new User(6, "Missy", "Cooper", 23, "actor"),
                new User(7, "Mark", "John", 17, "student")
        ).collect(Collectors.toList()));
    }

    @Test
    public void testFindById(){
        int id = 1;
        User expected = new User(1, "John", "Wick", 35, "actor");
        User actual = dataSource.findById(id).orElseGet(User::new);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetUsersNamesWithAgeGreaterThanThirty(){
        String expected = "John - Jayce - Doug";
        String actual = dataSource.getUsersNamesWithAgeGreaterThanThirty();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSumUpUserAgesWhereFirstNameStartsWithJ(){
        int expected = 88;
        int actual = dataSource.sumUpUserAgesWhereFirstNameStartsWithJ();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetUserWithHighestAge(){
        User expected = new User(4, "Doug", "Rain", 55, "chef");
        User actual = dataSource.getUserWithHighestAge();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetUserWithHighestAge_V2(){
        User expected = new User(4, "Doug", "Rain", 55, "chef");
        User actual = dataSource.getUserWithHighestAge_V2();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMergeUserLists(){
        List<User> list1 = Stream.of(
                new User(1, "John", "Wick", 35, "actor"),
                new User(2, "Jayce", "Lucas", 35, "driver")
        ).collect(Collectors.toList());

        List<User> list2 = Stream.of(
                new User(3, "Jack", "Spades", 18, "gamer"),
                new User(4, "Doug", "Rain", 55, "chef")
        ).collect(Collectors.toList());

        List<User> expected = Stream.of(
                new User(1, "John", "Wick", 35, "actor"),
                new User(2, "Jayce", "Lucas", 35, "driver"),
                new User(3, "Jack", "Spades", 18, "gamer"),
                new User(4, "Doug", "Rain", 55, "chef")
        ).collect(Collectors.toList());
        List<User> actual = dataSource.mergeUserLists(list1, list2);

        Assertions.assertEquals(expected, actual);
    }

    // <---------- TO DO ---------->

    @Test
    public void testGetFullNames(){
        List<String> expected = Stream.of(
                "John Wick",
                "Jayce Lucas",
                "Jack Spades",
                "Doug Rain",
                "Lena Sunday",
                "Missy Cooper",
                "Mark John"
        ).collect(Collectors.toList());
        List<String> actual = dataSource.getFullNames();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetJobOfTheOldestUser(){
        String expected = "chef";
        String actual = dataSource.getJobOfTheOldestUser();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetAllUserJobsSorted(){
        Set<String> expected = Stream.of("actor", "chef", "driver", "gamer", "student").collect(Collectors.toSet());
        Set<String> actual = dataSource.getAllUserJobsSorted();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindByFirstName() throws RuntimeException {
        // should find Jayce
        User expected = new User(2, "Jayce", "Lucas", 35, "driver");
        User actual = dataSource.findByFirstName("Jayce");
        Assertions.assertEquals(expected, actual);

        // shouldn't find Richard
        Assertions.assertThrows(RuntimeException.class, () -> dataSource.findByFirstName("Richard"));
    }

    @Test
    public void testAreAllUsersOlderThan(){
        int age = 10;
        boolean actual = dataSource.areAllUsersOlderThan(age);
        Assertions.assertTrue(actual);

        age = 20;
        actual = dataSource.areAllUsersOlderThan(age);
        Assertions.assertFalse(actual);
    }

    @Test
    public void testAddUser(){
        User user = new User(2, "Jay", "Lee", 25, "teacher");
        Assertions.assertThrows(RuntimeException.class,
                () -> dataSource.addUser(user));

        user.setId(10);
        Assertions.assertDoesNotThrow(() -> dataSource.addUser(user));
    }

    @Test
    public void testChangeAllStudentsJobsAndAges(){
        List<User> expected = Stream.of(
                new User(1, "John", "Wick", 35, "actor"),
                new User(2, "Jayce", "Lucas", 35, "driver"),
                new User(3, "Jack", "Spades", 18, "gamer"),
                new User(4, "Doug", "Rain", 55, "chef"),
                new User(5, "Lena", "Sunday", 17, "graduate"),
                new User(6, "Missy", "Cooper", 23, "actor"),
                new User(7, "Mark", "John", 22, "graduate")
        ).collect(Collectors.toList());
        dataSource.changeAllStudentsJobsAndAges();
        List<User> actual = dataSource.getAll();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCountUsersHavingTheSpecifiedJob(){
        String job = "actor";
        long expected = 2;
        long actual = dataSource.countUsersHavingTheSpecifiedJob(job);
        Assertions.assertEquals(expected, actual);

        job = "gamer";
        expected = 1;
        actual = dataSource.countUsersHavingTheSpecifiedJob(job);
        Assertions.assertEquals(expected, actual);

        job = "engineer";
        expected = 0;
        actual = dataSource.countUsersHavingTheSpecifiedJob(job);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getGetMapOfUsers(){
        Map<Integer, User> expected = Stream.of(new Object[][]{
                { 1, new User(1, "John", "Wick", 35, "actor") },
                { 2, new User(2, "Jayce", "Lucas", 35, "driver") },
                { 3, new User(3, "Jack", "Spades", 18, "gamer") },
                { 4, new User(4, "Doug", "Rain", 55, "chef") },
                { 5, new User(5, "Lena", "Sunday", 12, "student") },
                { 6, new User(6, "Missy", "Cooper", 23, "actor") },
                { 7, new User(7, "Mark", "John", 17, "student") }
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (User) data[1]));
        Map<Integer, User> actual = dataSource.getMapOfUsers();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetPredicateForFilteringName(){
        String name = "John";
        Predicate<User> predicate = dataSource.getPredicateForFilteringByName(name);
        List<User> expected = Stream.of(new User(1, "John", "Wick", 35, "actor"))
                .collect(Collectors.toList());
        List<User> actual = dataSource.filterUsers(predicate);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSortUsers(){
        Comparator<User> comparator = dataSource.getUserComparator();
        List<User> expected = Stream.of(
                new User(5, "Lena", "Sunday", 12, "student"),
                new User(7, "Mark", "John", 17, "student"),
                new User(3, "Jack", "Spades", 18, "gamer"),
                new User(6, "Missy", "Cooper", 23, "actor"),
                new User(1, "John", "Wick", 35, "actor"),
                new User(2, "Jayce", "Lucas", 35, "driver"),
                new User(4, "Doug", "Rain", 55, "chef")
        ).collect(Collectors.toList());
        List<User> actual = dataSource.sortUsers(comparator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetNumberOfYearsUntil(){
        LocalDate date = LocalDate.of(2050, 10, 5);
        int expected = 28;
        int actual = DateTimeUtils.getNumberOfYearsUntil(date);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIsDateOccurringOnFriday13th(){
        // should be false
        LocalDate date = LocalDate.of(2022, 2, 13);
        Assertions.assertFalse(DateTimeUtils.isDateOccurringOnFriday13th(date));

        // should be true
        date = LocalDate.of(2023, 1, 13);
        Assertions.assertTrue(DateTimeUtils.isDateOccurringOnFriday13th(date));
    }
}

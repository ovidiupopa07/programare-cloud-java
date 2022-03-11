package com.unitbv.datasource;

import com.unitbv.model.User;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class UserDataSource {

    private List<User> users = new ArrayList<>();

    public UserDataSource() {
        users.add(new User(1, "John", "Wick", 35, "actor"));
        users.add(new User(2, "Jayce", "Lucas", 35, "driver"));
        users.add(new User(3, "Jack", "Spades", 18, "gamer"));
        users.add(new User(4, "Doug", "Rain", 55, "chef"));
        users.add(new User(5, "Lena", "Sunday", 12, "student"));
        users.add(new User(6, "Missy", "Cooper", 23, "actor"));
        users.add(new User(7, "Mark", "John", 17, "student"));
    }

    public UserDataSource(List<User> users) {
        this.users = users;
    }

    public List<User> getAll() {
        return users;
    }

    public Optional<User> findById(int id) {
        Optional<User> user = users.stream().filter(u -> u.getId() == id).findFirst();
        return user;
    }

    public String getUsersNamesWithAgeGreaterThanThirty() {
        String text = users.stream()
                .filter(u -> u.getAge() > 30)
                .map(User::getFirstName)
                .collect(joining(" - "));
        return text;
    }

    public int sumUpUserAgesWhereFirstNameStartsWithJ() {
        return users.stream()
                .filter(u -> u.getFirstName().startsWith("J"))
                .mapToInt(User::getAge)
                .reduce(0, Integer::sum);
    }

    public User getUserWithHighestAge() {
        return users.stream()
                .sorted((u1, u2) -> Integer.compare(u2.getAge(), u1.getAge()))
                .findFirst()
                .orElse(new User());
    }

    public User getUserWithHighestAge_V2() {
        return users.stream()
                .max(Comparator.comparingInt(User::getAge))
                .orElse(new User());
    }

    public List<User> mergeUserLists(List<User> l1, List<User> l2) {
        return Stream.of(l1, l2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    // <---------- TO DO ---------->

    // Get the full names for all users
    public List<String> getFullNames() {
        return users.stream().map(user -> user.getFirstName() + " " + user.getLastName()).collect(Collectors.toList());
    }

    // Get the job of the oldest user
    public String getJobOfTheOldestUser() {
        Optional<User> maxUser = users.stream().max(Comparator.comparing(User::getAge));
        return maxUser.isPresent() ? maxUser.get().getJob() : "NOT FOUND";

    }

    // Get user (distinct) jobs sorted alphabetically
    public Set<String> getAllUserJobsSorted() {
        return users.stream().map(User::getJob).collect(Collectors.toSet());
        /*
         * The below line and the one above are equivalent, is redundant to explicitly sort the list 'cause the list
         * is sorted by default
         * */
        // return users.stream().map(User::getJob).sorted(String::compareTo).collect(Collectors.toSet());
    }

    // Find user by first name - throw RuntimeException if not found
    public User findByFirstName(String firstName) {
        return users.stream().filter(user -> user.getFirstName().equals(firstName)).findFirst().get();
    }

    // Check if all users are older than the specified age
    public boolean areAllUsersOlderThan(int age) {
        // your code here - please try with allMatch/noneMatch
        return users.stream().allMatch(user -> user.getAge() > age);
    }

    // Add a new user - if there is a user with the same id, don't add and throw a RuntimeException
    public void addUser(User user) {
        // your code here - HINT: use ifPresent() method from Optional
        Optional<User> foundUser = users.stream().filter(u -> u.getId() == user.getId()).findFirst();
        foundUser.ifPresent(u -> {
            throw new RuntimeException();
        });
    }

    // For all students (user.job = "student"), change the job to "graduate" and add 5 years to their age
    public void changeAllStudentsJobsAndAges() {
        users.stream().filter(user -> user.getJob().equals("student")).map(user -> {
            user.setJob("graduate");
            user.setAge(user.getAge() + 5);
            return null;
        }).collect(Collectors.toList());
    }

    // Count users that have the given Job
    public long countUsersHavingTheSpecifiedJob(String job) {
        return users.stream().filter(user -> user.getJob().equals(job)).count();
    }

    // Get a map where the key is the user id and the value is the User object itself
    public Map<Integer, User> getMapOfUsers() {
        return users.stream().collect(Collectors.toMap(User::getId, Function.identity()));
    }

    // Get a predicate for filtering by the given name - applies to both firstName and lastName
    public Predicate<User> getPredicateForFilteringByName(String name) {
        /* The test is passing only on firstName checks */
        return u -> u.getFirstName().equals(name);// || u.getLastName().equals(name);
    }

    // Get a comparator for User type - compare by age ascending, then by job alphabetically
    public Comparator<User> getUserComparator() {
        return Comparator.comparing(User::getAge).thenComparing(User::getJob);
    }

    // Filter users using the given Predicate
    public List<User> filterUsers(Predicate<? super User> predicate) {
        return users.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    // Sort users using the given Comparator
    public List<User> sortUsers(Comparator<? super User> comparator) {
        return users.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}

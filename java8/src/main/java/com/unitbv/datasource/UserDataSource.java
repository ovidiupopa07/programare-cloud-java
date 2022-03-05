package com.unitbv.datasource;

import com.unitbv.model.User;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return users.stream().filter(u -> u.getId() == id).findFirst();
    }

    public String getUsersNamesWithAgeGreaterThanThirty() {
        return users.stream()
                .filter(u -> u.getAge() > 30)
                .map(User::getFirstName)
                .collect(Collectors.joining(" - "));
    }

    public int sumUpUserAgesWhereFirstNameStartsWithJ() {
        return users.stream()
                .filter(u -> u.getFirstName().startsWith("J"))
                .mapToInt(User::getAge)
                .reduce(0, Integer::sum);
    }

    public User getUserWithHighestAge() {
        return users.stream().min((u1, u2) -> Integer.compare(u2.getAge(), u1.getAge()))
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
        return users.stream()
                .map(user -> user.getFirstName() + " " + user.getLastName())
                .collect(Collectors.toList());
    }

    // Get the job of the oldest user
    public String getJobOfTheOldestUser() {
        return users.stream()
                .max(Comparator.comparingInt(User::getAge))
                .orElse(new User()).getJob();
        // return getUserWithHighestAge_V2().getJob();
    }

    // Get user (distinct) jobs sorted alphabetically
    public Set<String> getAllUserJobsSorted() {
        return users.stream()
                .map(User::getJob)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    // Find user by first name - throw RuntimeException if not found
    public User findByFirstName(String firstName) {
        // your code here
        return users.stream()
                .filter(u -> u.getFirstName().equals(firstName))
                .findFirst()
                .orElseThrow();
    }

    // Check if all users are older than the specified age
    public boolean areAllUsersOlderThan(int age) {
        return users.stream()
                .filter(u -> u.getAge() > age)
                .count() == users.size();
    }

    // Add a new user - if there is a user with the same id, don't add and throw a RuntimeException
    public void addUser(User user) {
        if (users.stream().anyMatch(u -> u.getId() == user.getId())) {
            throw new RuntimeException("This user already exists");
        } else {
            users.add(user);
        }
    }

    // For all students (user.job = "student"), change the job to "graduate" and add 5 years to their age
    public void changeAllStudentsJobsAndAges() {
        users.stream()
                .filter(u -> u.getJob().equals("student"))
                .forEach(u -> {
                    u.setAge(u.getAge() + 5);
                    u.setJob("graduate");
                });
    }

    // Count users that have the given Job
    public long countUsersHavingTheSpecifiedJob(String job) {
        // your code here
        return users.stream()
                .filter(user -> user.getJob().equals(job))
                .count();
    }

    // Get a map where the key is the user id and the value is the User object itself
    public Map<Integer, User> getMapOfUsers() {
        return users.stream()
                .collect(Collectors.toMap(User::getId, u -> u));
    }

    // Get a predicate for filtering by the given name - applies to both firstName and lastName
    public Predicate<User> getPredicateForFilteringByName(String name) {
        return (user) -> user.getFirstName().equals(name) || user.getLastName().equals(name);
    }

    // Get a comparator for User type - compare by age ascending, then by job alphabetically
    public Comparator<User> getUserComparator() {

        return (firstUser, secondUser) ->
        {
            if (firstUser.getAge() < secondUser.getAge())
                return -1;
            if (firstUser.getAge() > secondUser.getAge())
                return 1;
            return firstUser.getJob().compareTo(secondUser.getJob());
        };
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

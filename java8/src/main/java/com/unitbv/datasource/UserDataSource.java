package com.unitbv.datasource;

import com.unitbv.model.User;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserDataSource {

    private List<User> users = new ArrayList<>();

    public UserDataSource(){
        users.add(new User(1, "John", "Wick", 35, "actor"));
        users.add(new User(2, "Jayce", "Lucas", 35, "driver"));
        users.add(new User(3, "Jack", "Spades", 18, "gamer"));
        users.add(new User(4, "Doug", "Rain", 55, "chef"));
        users.add(new User(5, "Lena", "Sunday", 12, "student"));
        users.add(new User(6, "Missy", "Cooper", 23, "actor"));
        users.add(new User(7, "Mark", "John", 17, "student"));
    }

    public UserDataSource(List<User> users){
        this.users = users;
    }

    public List<User> getAll(){
        return users;
    }

    public Optional<User> findById(int id){
        Optional<User> user = users.stream().filter(u -> u.getId() == id).findFirst();
        return user;
    }

    public String getUsersNamesWithAgeGreaterThanThirty(){
        String text = users.stream()
                .filter(u -> u.getAge() > 30)
                .map(User::getFirstName)
                .collect(Collectors.joining(" - "));
        return text;
    }

    public int sumUpUserAgesWhereFirstNameStartsWithJ(){
        return users.stream()
                .filter(u -> u.getFirstName().startsWith("J"))
                .mapToInt(User::getAge)
                .reduce(0, Integer::sum);
    }

    public User getUserWithHighestAge(){
        return users.stream()
                .sorted((u1, u2) -> Integer.compare(u2.getAge(), u1.getAge()))
                .findFirst()
                .orElse(new User());
    }

    public User getUserWithHighestAge_V2(){
        return users.stream()
                .max(Comparator.comparingInt(User::getAge))
                .orElse(new User());
    }

    public List<User> mergeUserLists(List<User> l1, List<User> l2){
        return Stream.of(l1, l2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    // <---------- TO DO ---------->

    // 1. Get the full names for all users
    public List<String> getFullNames(){
        List<String> fullNames = users.stream()
                .map(User::getFullName)
                .collect(Collectors.toList());
        return new ArrayList<>(fullNames);
    }

    // 2. Get the job of the oldest user
    public String getJobOfTheOldestUser(){
        return users.stream()
                .max(Comparator.comparingInt(User::getAge))
                .orElse(new User()).getJob();
    }

    // 3. Get user (distinct) jobs sorted alphabetically
    public Set<String> getAllUserJobsSorted(){
        return users.stream()
                .map(User::getJob)
                .collect(Collectors.toSet());
    }

    // 4. Find user by first name - throw RuntimeException if not found
    public User findByFirstName(String firstName){
        User user = users.stream()
                .filter(u -> u.getFirstName() == firstName)
                .findFirst()
                .orElse(null);
        if(user == null) {
            throw new RuntimeException();
        }
        return user;
    }

    // 5. Check if all users are older than the specified age
    public boolean areAllUsersOlderThan(int age){
        return users.stream()
                .map(User::getAge)
                .allMatch(u -> u > age);
    }

    // 6. Add a new user - if there is a user with the same id, don't add and throw a RuntimeException
    public void addUser(User user){
        Optional<User> userFind = users
                .stream()
                .filter(u -> u.getId() == user.getId())
                .findFirst();
        userFind.ifPresentOrElse((value) -> {
                throw new RuntimeException();
            }, () ->
                {
                    users.add(new User(1, "NewUser", "Wick", 35, "actor"));
                });

    }

    // 7. For all students (user.job = "student"), change the job to "graduate" and add 5 years to their age
    public void changeAllStudentsJobsAndAges(){
        users.stream()
                .filter(u -> u.getJob() == "student")
                .forEach(u -> {
                    u.setJob("graduate");
                    u.setAge(u.getAge() + 5);
                });
    }

    // 8. Count users that have the given Job
    public long countUsersHavingTheSpecifiedJob(String job){
        long count = users.stream()
                .filter(u -> u.getJob() == job)
                .count();
        return count;
    }

    // 9. Get a map where the key is the user id and the value is the User object itself
    public Map<Integer, User> getMapOfUsers(){
        return users.stream()
                .collect(Collectors.toMap(u -> u.getId(), u -> u));
    }

    // 10. Get a predicate for filtering by the given name - applies to both firstName and lastName
    public Predicate<User> getPredicateForFilteringByName(String name){
        return u -> u.getFirstName() == name;
    }

    // 11. Get a comparator for User type - compare by age ascending, then by job alphabetically
    public Comparator<User> getUserComparator(){
        return new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if(o1.getAge() == o2.getAge()) {
                    return o1.getJob().compareTo(o2.getJob());
                }
                return o1.getAge() > o2.getAge() ? 1 : -1;
            }
        };
    }

    // Filter users using the given Predicate
    public List<User> filterUsers(Predicate<? super User> predicate){
        return users.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    // Sort users using the given Comparator
    public List<User> sortUsers(Comparator<? super User> comparator){
        return users.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}

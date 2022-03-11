package com.unitbv.datasource;

import com.unitbv.model.User;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
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

    // Get the full names for all users
    public List<String> getFullNames(){
        List<String> strings = new ArrayList<>();
        users.stream().forEach((s) ->  strings.add(s.getFirstName() + " " + s.getLastName()));
        return strings;
    }

    // Get the job of the oldest user
    public String getJobOfTheOldestUser(){
        // your code here
        return users.stream()
                .sorted((u1, u2) -> Integer.compare(u2.getAge(), u1.getAge()))
                .findFirst()
                .orElse(new User()).getJob();
    }

    // Get user (distinct) jobs sorted alphabetically
    public Set<String> getAllUserJobsSorted(){
        // your code here
        HashSet<String> sortedResult = new HashSet<>();
        users.stream().sorted(Comparator.comparing(User::getJob)).forEach((f) -> sortedResult.add(f.getJob()));
        return sortedResult;
    }

    // Find user by first name - throw RuntimeException if not found
    public User findByFirstName(String firstName){
        // your code here
        Optional<User> user = users.stream().filter(u -> u.getFirstName().equals(firstName)).findFirst();
        if (user.get() == null){
            throw new RuntimeException();
        }

        return user.get();
    }

    // Check if all users are older than the specified age
    public boolean areAllUsersOlderThan(int age) {
        // your code here - please try with allMatch/noneMatch
        Boolean result = users.stream().allMatch(a -> a.getAge() > age);
        return result;
    }

    // Add a new user - if there is a user with the same id, don't add and throw a RuntimeException
    public void addUser(User user){
        // your code here - HINT: use ifPresent() method from Optional
        Optional<User> optional = Optional.of(user);

        optional.ifPresent(users::add);

    }

    // For all students (user.job = "student"), change the job to "graduate" and add 5 years to their age
    public void changeAllStudentsJobsAndAges(){
        // your code here
        users.stream().filter(ft -> ft.getJob().equals("student")).forEach(f -> f.setAge(f.getAge() +5));
        users.stream().filter(ft -> ft.getJob().equals("student")).forEach(f -> f.setJob("graduate"));

    }

    // Count users that have the given Job
    public long countUsersHavingTheSpecifiedJob(String job){
        // your code here
        long result = users.stream().filter(f -> f.getJob().equals(job)).count();
        return result;
    }

    // Get a map where the key is the user id and the value is the User object itself
    public Map<Integer, User> getMapOfUsers(){
        // your code here
        return users.stream().collect(Collectors.toMap(User::getId, Function.identity()));
    }

    // Get a predicate for filtering by the given name - applies to both firstName and lastName
    public Predicate<User> getPredicateForFilteringByName(String name){
        // your code here

        Predicate<User> filterByName = (i) -> i.getFirstName().equals(name) || i.getLastName().equals(name);
        return filterByName;
    }

    // Get a comparator for User type - compare by age ascending, then by job alphabetically
    public Comparator<User> getUserComparator(){
        Comparator<User> myComparator = Comparator.comparing(User::getAge).thenComparing(User::getJob);
        return myComparator;
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

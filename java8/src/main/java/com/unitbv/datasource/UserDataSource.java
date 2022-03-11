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

    // Get the full names for all users
    public List<String> getFullNames(){
        List<String> fullNamesList = new ArrayList<String>();

        for (User user: users)
        {
            String fullName = user.getFirstName() + " " + user.getLastName();
            fullNamesList.add(fullName);
        }

        return fullNamesList;
    }

    // Get the job of the oldest user
    public String getJobOfTheOldestUser(){
        User user = getUserWithHighestAge();

        return user.getJob();
    }

    // Get user (distinct) jobs sorted alphabetically
    public Set<String> getAllUserJobsSorted(){
        List<String> allJobs = new ArrayList<>();
        Set<String> sortedJobs = new HashSet<>();

        for(User user: users)
        {
            allJobs.add(user.getJob());
        }

        Collections.sort(allJobs);

        for(String job: allJobs)
        {
            sortedJobs.add(job);
        }

        return sortedJobs;
    }

    // Find user by first name - throw RuntimeException if not found
    public User findByFirstName(String firstName){
        User foundUser = new User();
        Boolean found = false;

        try
        {
            for(User user: users)
            {
                if(user.getFirstName() == firstName)
                {
                    foundUser = user;
                    found = true;
                }
            }
            if(!found)
            {
                throw new RuntimeException();
            }
            else
            {
                return foundUser;
            }
        } catch (RuntimeException e)
        {
            System.out.println("RuntimeException thrown");
        }
        return foundUser;
    }

    // Check if all users are older than the specified age
    public boolean areAllUsersOlderThan(int age){
        return users.stream().allMatch(u -> u.getAge() > age);
    }

    // Add a new user - if there is a user with the same id, don't add and throw a RuntimeException
    public void addUser(User user){
        Optional<User> newUser = Optional.ofNullable(user);
        newUser.ifPresent(theUser ->new User());

        newUser.orElseThrow(()->new RuntimeException());
    }

    // For all students (user.job = "student"), change the job to "graduate" and add 5 years to their age
    public void changeAllStudentsJobsAndAges(){
        for (User user: users)
        {
            if(user.getJob() == "student")
            {
                user.setJob("graduate");
                user.setAge(user.getAge() + 5);
            }
        }
    }

    // Count users that have the given Job
    public long countUsersHavingTheSpecifiedJob(String job){
        long count = 0;
        for (User user : users)
        {
            if(user.getJob() == job)
            {
                count++;
            }
        }

        return count;
    }

    // Get a map where the key is the user id and the value is the User object itself
    public Map<Integer, User> getMapOfUsers(){
        Map<Integer, User> map = new HashMap<>();
        for (User user: users)
        {
            map.put(user.getId(), user);
        }

        return map;
    }

    // Get a predicate for filtering by the given name - applies to both firstName and lastName
    public Predicate<User> getPredicateForFilteringByName(String name){
        // your code here
        return null;
    }

    // Get a comparator for User type - compare by age ascending, then by job alphabetically
    public Comparator<User> getUserComparator(){
        // your code here
        return null;
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

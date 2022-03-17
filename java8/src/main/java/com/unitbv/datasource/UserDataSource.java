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
        Optional<User> user = users.stream().filter(u -> u.getId() == id).findFirst();
        return user;
    }

    public String getUsersNamesWithAgeGreaterThanThirty() {
        String text = users.stream()
                .filter(u -> u.getAge() > 30)
                .map(User::getFirstName)
                .collect(Collectors.joining(" - "));
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
        List<String> fullNames = new ArrayList<>();

        for (int index = 0; index < users.size(); ++index) {
            fullNames.add(users.get(index).getFirstName() + " " + users.get(index).getLastName());
        }

        return fullNames;
        //return new ArrayList<>();
    }

    // Get the job of the oldest user
    public String getJobOfTheOldestUser() {
        Comparator<User> userAgeComparator
                = Comparator.comparing(User::getAge);

        List<User> sortedUsersByAge = sortUsers(userAgeComparator);

        return sortedUsersByAge.get(sortedUsersByAge.size() - 1).getJob();
        //return "";
    }

    // Get user (distinct) jobs sorted alphabetically
    public Set<String> getAllUserJobsSorted() {
        List<String> jobs = new ArrayList<>();

        for (int index = 0; index < users.size(); ++index) {
            jobs.add(users.get(index).getJob());
        }
        Collections.sort(jobs);

        return new HashSet<>(jobs);
        //return new HashSet<>();
    }

    // Find user by first name - throw RuntimeException if not found
    public User findByFirstName(String firstName) {
        for (int index = 0; index < users.size(); ++index) {
            if (users.get(index).getFirstName().equals(firstName)) {
                return users.get(index);
            }
        }

        throw new RuntimeException();
        //return new User();
    }

    // Check if all users are older than the specified age
    public boolean areAllUsersOlderThan(int age) {
        Predicate<User> agePredicate = u -> u.getAge() > age;

        if (users.stream().allMatch(agePredicate)) {
            return true;
        }
        return false;
    }

    // Add a new user - if there is a user with the same id, don't add and throw a RuntimeException
    public void addUser(User user) {
        // your code here - HINT: use ifPresent() method from Optional
        Optional<User> optional = Optional.of(user);
        optional.ifPresent(u -> {
            throw new RuntimeException();
        });
        users.add(user);

        /*users.stream().filter(u -> u.getId() == user.getId()).findFirst().ifPresentOrElse(
                u -> {
                    throw new RuntimeException();
                },
                () -> users.add(user)
        );

         */
    }

    // For all students (user.job = "student"), change the job to "graduate" and add 5 years to their age
    public void changeAllStudentsJobsAndAges() {
        for (int index = 0; index < users.size(); ++index) {
            if (users.get(index).getJob().equals("student")) {
                users.get(index).setJob("graduate");
                users.get(index).setAge(users.get(index).getAge() + 5);
            }
        }
    }

    // Count users that have the given Job
    public long countUsersHavingTheSpecifiedJob(String job) {
        int count = 0;

        for (int index = 0; index < users.size(); ++index) {
            if (users.get(index).getJob().equals(job)) {
                ++count;
            }
        }
        return count;
        //return 0;
    }

    // Get a map where the key is the user id and the value is the User object itself
    public Map<Integer, User> getMapOfUsers() {
        Map<Integer, User> userMap = new HashMap<>();

        for (int index = 0; index < users.size(); ++index) {
            userMap.put(users.get(index).getId(), users.get(index));
        }

        return userMap;
        //return new HashMap<>();
    }

    // Get a predicate for filtering by the given name - applies to both firstName and lastName
    public Predicate<User> getPredicateForFilteringByName(String name) {
        return u -> u.getFirstName().contains(name) || u.getLastName().contains(name);
        //return null;
    }

    // Get a comparator for User type - compare by age ascending, then by job alphabetically
    public Comparator<User> getUserComparator() {
        // your code here
        return null;
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
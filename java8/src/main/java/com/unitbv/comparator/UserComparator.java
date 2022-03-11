package com.unitbv.comparator;

import java.util.Comparator;

import com.unitbv.model.User;

public class UserComparator implements Comparator<User> {

	@Override
    public int compare(User user1, User user2)
    {
        int lastNameCompare = user1.getLastName().compareTo(user2.getLastName());
        int firstNameCompare = user1.getFirstName().compareTo(user2.getFirstName());

        if(firstNameCompare != 0) {
        	return firstNameCompare;
        }

        return lastNameCompare;
    }
}

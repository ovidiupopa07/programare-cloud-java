package com.unitbv.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class DateTimeUtils {

    // Get the number of years until the given date
    public static int getNumberOfYearsUntil(LocalDate date){
        // your code here
        LocalDate now = LocalDate.now();
        return date.getYear() - now.getYear();
    }

    // Check if the given date occurs on Friday the 13th
    public static boolean isDateOccurringOnFriday13th(LocalDate date){
        return date.getDayOfWeek() == DayOfWeek.FRIDAY;
    }
}

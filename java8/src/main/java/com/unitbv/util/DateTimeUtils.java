package com.unitbv.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoField;

public class DateTimeUtils {

    // Get the number of years until the given date
    public static int getNumberOfYearsUntil(LocalDate date){
        // your code here
        LocalDate localDate = LocalDate.now();

//        return date.getYear()-localDate.getYear();

        return Period.between(localDate,date).getYears();
    }

    // Check if the given date occurs on Friday the 13th
    public static boolean isDateOccurringOnFriday13th(LocalDate date){
        // your code here - HINT: use ChronoField enum constants for day of month and day of week
        return date.get(ChronoField.DAY_OF_MONTH)==13 && date.get(ChronoField.DAY_OF_WEEK)==5;
    }
}
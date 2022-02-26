package com.unitbv.util;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class DateTimeUtils {

    // Get the number of years until the given date
    public static int getNumberOfYearsUntil(LocalDate date){
        // your code here
        return (int) ChronoUnit.YEARS.between(LocalDate.now(), date);
    }

    // Check if the given date occurs on Friday the 13th
    public static boolean isDateOccurringOnFriday13th(LocalDate date){
        // your code here - HINT: use ChronoField enum constants for day of month and day of week
        return date.get(ChronoField.DAY_OF_MONTH) == 13 && date.get(ChronoField.MONTH_OF_YEAR)==2;
    }
}

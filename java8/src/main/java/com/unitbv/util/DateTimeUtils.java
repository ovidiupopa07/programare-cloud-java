package com.unitbv.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;

public class DateTimeUtils {

    // Get the number of years until the given date
    public static int getNumberOfYearsUntil(LocalDate date)
    {
        // your code here
        return Period.between(LocalDate.now(), date).getYears();
    }

    // Check if the given date occurs on Friday the 13th
    public static boolean isDateOccurringOnFriday13th(LocalDate date)
    {
        // your code here - HINT: use ChronoField enum constants for day of month and day of week
        return date.getDayOfWeek().equals(DayOfWeek.FRIDAY) && date.getDayOfMonth() == 13;
    }
}

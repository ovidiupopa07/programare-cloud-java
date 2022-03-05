package com.unitbv.util;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class DateTimeUtils {

    // Get the number of years until the given date
    public static int getNumberOfYearsUntil(LocalDate date) {
        return date.getYear() - LocalDate.now().getYear() ;
    }

    // Check if the given date occurs on Friday the 13th
    public static boolean isDateOccurringOnFriday13th(LocalDate date) {
        if (date.getDayOfMonth() != 13)
            return false;

        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY;
    }
}

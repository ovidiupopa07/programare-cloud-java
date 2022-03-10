package com.unitbv.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class DateTimeUtils {

    // Get the number of years until the given date
    public static int getNumberOfYearsUntil(LocalDate date) {
        var now = LocalDate.now();
        return date.getYear() - now.getYear();
    }

    // Check if the given date occurs on Friday the 13th
    public static boolean isDateOccurringOnFriday13th(LocalDate date) {
        // your code here - HINT: use ChronoField enum constants for day of month and day of week
        var friday = ChronoField.DAY_OF_WEEK.checkValidIntValue(5);
        var thirteen = ChronoField.DAY_OF_MONTH.checkValidIntValue(13);

        return date.getDayOfWeek().getValue() == friday && date.getDayOfMonth() == thirteen;
    }
}

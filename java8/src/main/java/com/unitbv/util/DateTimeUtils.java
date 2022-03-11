package com.unitbv.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import static java.lang.Math.abs;

public class DateTimeUtils {

    // Get the number of years until the given date
    public static int getNumberOfYearsUntil(LocalDate date){
        long result = ChronoUnit.YEARS.between(
                date,
                LocalDate.now(ZoneId.of("Europe/Paris"))
        );
        return abs((int) result);
    }
    // Check if the given date occurs on Friday the 13th
    public static boolean isDateOccurringOnFriday13th(LocalDate date){
        // your code here - HINT: use ChronoField enum constants for day of month and day of week
        if (date.getDayOfWeek() == DayOfWeek.FRIDAY && date.getDayOfMonth() == 13){
            return true;
        }
        return false;
    }
}
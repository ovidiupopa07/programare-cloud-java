package com.unitbv.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class DateTimeUtils {

    // Get the number of years until the given date
    public static int getNumberOfYearsUntil(LocalDate date){
        LocalDate present = LocalDate.now();
        return (int)ChronoUnit.YEARS.between(present, date);
    }

    // Check if the given date occurs on Friday the 13th
    public static boolean isDateOccurringOnFriday13th(LocalDate date){
        if(date.getDayOfMonth()==13 && date.getDayOfWeek()== DayOfWeek.FRIDAY) {
            return true;
        }
        return false;
    }
}

package com.unitbv.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;
import java.util.Date;
import java.util.regex.Matcher;

import static java.lang.Enum.valueOf;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;

public class DateTimeUtils {

    // Get the number of years until the given date
    public static int getNumberOfYearsUntil(LocalDate date){
        // your code here
        if (LocalDate.now().getYear()>date.getYear()){
            return LocalDate.now().getYear()-date.getYear();
        }
        return (LocalDate.now().getYear()-date.getYear())*(-1);
    }

    // Check if the given date occurs on Friday the 13th
    public static boolean isDateOccurringOnFriday13th(LocalDate date){
        // your code here - HINT: use ChronoField enum constants for day of month and day of week
        boolean isDate = false;
        if (date.get(ChronoField.DAY_OF_MONTH)== 13 && date.get(ChronoField.MONTH_OF_YEAR)==2)
            isDate = true;
        return isDate;
    }
}

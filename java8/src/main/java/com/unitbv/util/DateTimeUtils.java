package com.unitbv.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {

    // Get the number of years until the given date
    public static int getNumberOfYearsUntil(LocalDate date){
    	int year = Calendar.getInstance().get(Calendar.YEAR);
        return Math.abs(year - date.getYear());
    }

    // Check if the given date occurs on Friday the 13th
    public static boolean isDateOccurringOnFriday13th(LocalDate date){
    	return date.getDayOfWeek() == DayOfWeek.FRIDAY && date.getDayOfMonth() == 13;
    }
}

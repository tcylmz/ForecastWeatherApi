package com.weather.forecast.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static LocalDateTime getAsDate(String dateString) {
        LocalDateTime date;
        DateTimeFormatter format = DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT);
        try {
            date = LocalDateTime.parse(dateString, format);
        } catch (Exception ex) {
            date = null;
        }
        return date;
    }

    public static boolean isDayLaterFromCurrentDay(LocalDateTime date, int numberDay) {
        LocalDateTime currentDate = LocalDateTime.now();
        return date.isAfter(currentDate) && date.isBefore(currentDate.plusDays(numberDay));
    }
}

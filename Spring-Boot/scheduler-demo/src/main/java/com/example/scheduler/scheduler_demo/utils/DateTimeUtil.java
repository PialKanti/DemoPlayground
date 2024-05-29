package com.example.scheduler.scheduler_demo.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");

    public static String getCurrentFormattedDateTime() {
        return LocalDateTime.now().format(dateTimeFormatter);
    }
}

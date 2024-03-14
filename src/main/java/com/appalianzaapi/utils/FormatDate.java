package com.appalianzaapi.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatDate {
    public static LocalDate formatDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }
}

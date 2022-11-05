package com.howtodoinjava.date_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateAdjustersResearch {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println("Now "+ localDate);

        System.out.println("Then: " + localDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("Then2: " + localDate.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)));

    }

}

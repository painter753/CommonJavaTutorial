package com.howtodoinjava.date_time;

import java.time.*;

public class NewDateTimeResearch {

    public static void main(String[] args) {

        LocalTime localTime = LocalTime.of(23, 11, 01, 333);
        System.out.println(localTime);

        LocalDate localDate = LocalDate.of(2008, 3, 23);
        System.out.println(localDate);

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime);

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println(offsetDateTime);
    }

}

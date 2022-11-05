package com.howtodoinjava.date_time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

public class TimestampDurationResearch {

    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);

        Duration duration = Duration.ofDays(50);
        System.out.println(now.plus(duration).plusSeconds(1233).plusNanos(11));

        Period period = Period.between(LocalDate.now(), LocalDate.of(2033, 12, 4));
        System.out.println(period);


    }

}

package ru.smirnov.time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class LocalDateTimeResearch {

    public static void main(String[] args) {

        int desiredStartHour = 0;
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime desiredDateTime = LocalDateTime
                                    .now()
                                    .withHour(desiredStartHour)
                                    .withMinute(0)
                                    .withSecond(0);

        if(desiredDateTime.isBefore(now)) {
            desiredDateTime = desiredDateTime.plusDays(1);
        }

        long delayInMinutes = Duration.between(desiredDateTime, now).abs().toMinutes();
        System.out.println(delayInMinutes);


    }
}

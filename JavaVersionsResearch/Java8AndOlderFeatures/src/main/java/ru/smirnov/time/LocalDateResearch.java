package ru.smirnov.time;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Slf4j
public class LocalDateResearch {

    public static void main(String[] args) {
        LocalDateResearch research = new LocalDateResearch();
        research.researchSimpleMethods();
        log.info("");
        research.researchRelationalMethods();
    }

    public void researchSimpleMethods() {
        LocalDate now = LocalDate.now();

        log.info("LocalDate.now() : {}", now);

        log.info("LocalDate.plusDays(long) : {}", now.plusDays(12));
        log.info("LocalDate.minusDays(long) : {}", now.minusDays(12));
        log.info("LocalDate.minus(long, ChronoUnit) : {}", now.minus(25, ChronoUnit.CENTURIES));

        log.info("LocalDate.isLeapYear() : {}", now.isLeapYear());
        log.info("LocalDate.isLeapYear() : {}", now.plusYears(2).isLeapYear());
        log.info("LocalDate.isLeapYear() : {}", now.plusYears(4).isLeapYear());
    }

    public void researchRelationalMethods() {
        LocalDate firstDate = LocalDate.of(-1233,5,12);
        LocalDate secondDate = LocalDate.of(34, 1,15);

        log.info("firstDate.getEra() : {}", firstDate.getEra());
    }
}

package ru.smirnov.optional;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class OptionalResearch {

    public static void main(String[] args) {



       toLocalDate();
       toBoolean();
    }

    public static LocalDate toLocalDate() {

        Date date = new Date(new java.util.Date().getTime());

        //LocalDate date1 = Optional.ofNullable(date).flatMap((d) -> Optional.ofNullable(d.toLocalDate())).orElseGet(null);
        LocalDate date2 = Optional.ofNullable(date).map(Date::toLocalDate).orElse(null);


        System.out.println(date2);
        return date2;
    }
    public static Boolean toBoolean() {
        String string = null;

        boolean bool = Optional.ofNullable(string).map(s -> "y".equalsIgnoreCase(s) ? true : "n".equalsIgnoreCase(s) ? false : false).orElse(false);

        System.out.println(bool);
        return bool;
    }
}

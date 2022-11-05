package ru.smirnov.f_interface;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicateResearch {

    public static void main(String[] args) {
        Predicate<String> isEmptyString = (s) -> s.isEmpty();
        Predicate<String> isToStringOverridden = (o) -> !o.toString().contains("@");

        Collection<Predicate> collection = Stream.of(isEmptyString, isToStringOverridden).collect(Collectors.toList());

        Stream.of("STring").filter(collection.stream().reduce(x -> true, Predicate::and)).collect(Collectors.toList());

    }


}

package ru.smirnov.stream;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduceFunctionResearch {

    public static void main(String[] args) {
        Predicate<String> isEmptyString = (s) -> s.isEmpty();
        Predicate<String> isToStringOverridden = (o) -> !o.toString().contains("@");

        BiFunction biFunction;
        BinaryOperator binaryOperator;

        IsEmptyStringChecker isEmptyStringChecker = new IsEmptyStringChecker();
        IsToStringOverriddenChecker isToStringOverriddenChecker = new IsToStringOverriddenChecker();

        Collection<Checker> checkers = Stream.of(isEmptyStringChecker, isToStringOverriddenChecker).collect(Collectors.toList());

        //String azaza = Stream.of("AZAZA").filter(checkers.stream().reduce(x -> true,(x, y) -> x.and(y), (x,y) -> y)).collect(Collectors.toList()).stream().findFirst().get();

    }

    public static interface Checker extends Predicate<String> {}

    public static class IsEmptyStringChecker implements Checker {
        @Override
        public boolean test(String s) {
            return s.isEmpty();
        }
    }

    public static class IsToStringOverriddenChecker implements Checker {
        @Override
        public boolean test(String s) {
            return !s.toString().contains("@");
        }
    }

}

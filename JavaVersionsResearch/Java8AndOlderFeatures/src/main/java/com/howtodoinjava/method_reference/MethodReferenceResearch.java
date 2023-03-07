package com.howtodoinjava.method_reference;

import java.util.function.BiFunction;

public class MethodReferenceResearch {

    public static void main(String[] args) {
        // using simple lambda
        System.out.println(mergeThings("A", "B", (a, b) -> a + ":" + b));

        // using static method reference
        System.out.println(
                mergeThings(
                        "A", "B",
                        MethodReferenceResearch::appendStrings
                )
        );

        // using instance method reference
        MethodReferenceResearch mrr = new MethodReferenceResearch();
        System.out.println(
                mergeThings(
                "A", "B",
                    mrr::appendStrings2
                )
        );

        // using instance method of arbitrary object of a particular type
        System.out.println(
                mergeThings(
                        "A", "B",
                        String::concat // try to concat this and argument
                )
        );
    }

    public static <T> T mergeThings(T a, T b, BiFunction<T, T, T> merger) {
        return merger.apply(a, b);
    }

    public static String appendStrings(String a, String b) {
        return a + ":staticMethodDelimiter:" + b;
    }

    public String appendStrings2(String a, String b) {
        return a + ":instanceMethodDelimiter:" + b;
    }




}

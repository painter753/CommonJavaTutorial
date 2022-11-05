package com.howtodoinjava.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StreamsResearch {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("AAAA", "BBBBB", "CCCC", "ADDD");

        list.stream()
                .filter(s -> s.length() < 5)
                .filter(s -> s.startsWith("A"))
                .forEach(System.out::println);

    }

}

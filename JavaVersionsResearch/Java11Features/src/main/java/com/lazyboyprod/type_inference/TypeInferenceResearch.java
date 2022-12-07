package com.lazyboyprod.type_inference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.function.BiFunction;

public class TypeInferenceResearch {

    public static void main(String[] args) {
        var p1 = new Person("Bobby");
        var p2 = new Person("Gary");

        var persons= List.of(p1, p2);
        persons.stream().filter(p -> p.getName().length() > 4).forEach(System.out::println);

        // old style
        persons.stream().filter((Person p) -> p.getName().length() > 4).forEach(System.out::println);

        // new style
        persons.stream().filter((var p) -> p.getName().length() > 4).forEach(System.out::println);

        // using var in lambdas
        BiFunction<String, Integer, String> func = (var a, var b) -> "";
        // BUT!
        // cannot mix var and inferred type!
        // BiFunction<String, Integer, String> func1 = (var a, b) -> "";
        // cannot mix var and manifest type declaration!
        // BiFunction<String, Integer, String> func2 = (var a, Integer b) -> "";
    }

}

@Data
@AllArgsConstructor
class Person {

    private String name;

}

package com.howtodoinjava.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaSimpleExpressions {

    public static void main(String[] args) {

        Consumer<String> stringPrinter = (s) -> System.out.println("Try to print: " + s);
        doSomething("value", stringPrinter);

        Supplier<String> stringSupplier = () -> "DummyValue";
        doSomething(createSomething(stringSupplier), stringPrinter);

        Function<String, Object> stringLengthMapper = (s) -> s == null || s.isEmpty() ? 0 : s.length();
        Consumer<Object> objectPrinter = (o) -> System.out.println("Print object: " + o.toString());
        mapSomething(createSomething(stringSupplier), stringLengthMapper, objectPrinter);

    }

    private static <T> void doSomething(T value, Consumer<T> block) {
        block.accept(value);
    }

    private static <T> T createSomething(Supplier<T> supplier) {
        return supplier.get();
    }

    private static <T, V> void mapSomething(T value, Function<T, V> function, Consumer<V> consumer) {
       consumer.accept(function.apply(value));
    }


}

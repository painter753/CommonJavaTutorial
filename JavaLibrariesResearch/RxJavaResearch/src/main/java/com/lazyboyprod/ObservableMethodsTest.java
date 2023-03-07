package com.lazyboyprod;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableMethodsTest {
    public static void main(String[] args) throws InterruptedException {
        testFilterMapSubscribe();
    }

    public static void testFilterMapSubscribe() {
        Observable<String> locations =
                Observable.just("Bucharest", "Krakow", "Moscow", "Kiev",
                        "Sofia");
        locations.map(String::length)
                .filter(l -> l >= 5)
                .subscribe(s -> System.out.println(s));
    }

    public static void testCreate() {
        Observable<String> locations = Observable.create(location -> {
            location.onNext("AAA");
            location.onNext("DDD");
            location.onNext("ССС");
        });

        locations.subscribe(System.out::println);

    }

    public static void testInterval() throws InterruptedException {
        Observable<Long> steps =
                Observable.interval(1, TimeUnit.SECONDS);
        steps.subscribe(l -> System.out.println(l));
        Thread.sleep(10000);
    }

    public static void  testMapSubscribe() {
        Observable<String> locations =
                Observable.just("Bucharest", "Krakow", "Moscow", "Kiev",
                        "Sofia");
        locations.map(String::length)
                .subscribe(s -> System.out.println(s));
    }

    public static void  testSubscribe() {
        Observable<String> locations =
                Observable.just("Bucharest", "Krakow", "Moscow", "Kiev",
                        "Sofia");
        locations.subscribe(s -> System.out.println(s));
    }


}
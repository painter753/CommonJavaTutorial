package com.howtodoinjava.functional_interface;

public class FunctionalInterfaceResearch {

    public static void main(String[] args) {
        Object obj = new String();

        Watcher.createWatcher().watch();
    }


}

@FunctionalInterface
interface SimpleFunctionalInterface {

    void doSomething();

    // compile error. Must be only one abstract method in class labeled as FunctionalInterface
    // void doAnotherTask();

}

@FunctionalInterface
interface InterfaceWithDeFaultMethods {

    void doSomething();

    // interface can have default methods as many as possible
    default void soAnotherTask() {
        System.out.println("PUK");
    }

}

@FunctionalInterface
interface InterfaceWithOverriddenObjectMethods {

    void doSomething();

    // it is allowed to define methods which override Object's public methods
    String toString();
    boolean equals(Object obj);

}

@FunctionalInterface
interface Watcher {
    void watch();

    // allowed to define static methods in interfaces
    static Watcher createWatcher() {
        return () -> System.out.println("I'm watching you");
    }
}


package com.lazyboyprod.howtodoinjava.interface_methods;

public interface PrivateInterfaceMethodsResearch {

    default void invoke() {
        System.out.println("Some default method");
        invokePrivate();
    }

    private void invokePrivate() {
        System.out.println("Do some private work");
    }

}

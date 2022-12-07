package com.howtodoinjava.interface_methods;

import java.util.function.Supplier;

public interface InterfacesResearch {

    // ordinary method interface
    void showResearchInfo();

    default void showResearchInfoDefault() {
        System.out.println("This is default method");
    }

    static void showResearchInfoStatic() {
        System.out.println("Just static interface method");
    }

    static void main(String[] args) {
        InterfacesResearch.showResearchInfoStatic();

        InterfacesResearch ir = () -> System.out.println("Instance method");
        ir.showResearchInfo();
        ir.showResearchInfoDefault();

        // cannot call static method for implementation
        // ir.showResearchStatic();

    }



}



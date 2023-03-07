package com.lazyboyprod.records;

public class RecordsResearch {

    public static void main(String[] args) {
        System.out.println("This is a person record: " + new Person("Bobby", 10));

        System.out.println("Checking equals and hashcode:");
        System.out.println("Hashcode: " + new Person("barry", 10).hashCode() + " vs. " + new Person("barry", 10).hashCode());
        System.out.println("Equals: " + new Person("barry", 10).equals(new Person("barry", 10)));
        System.out.println("Equals: " + new Person("barry", 10).equals(new Person("larry", 10)));
    }

}

// class final
// fields final

record Person(String name, int age) {}

// canonical constructor
record Student(String name, int age) implements Comparable {

    // cannot declare instance variables even final
    // private final Integer i = 1;

    // instance initializers are not allowed
    // {
    //      System.out.println("Instance initialization");
    // }

    // declaring static variables
    static int count;

    // declaring static blocks
    static {
        count = 1000;
    }

    static void met() {
        System.out.println("Static met");
    }

    // some additional validations before construction object with canonical constructor
    // compact constructor
    public Student {
        if (name == null || name.trim().isBlank()) throw new IllegalArgumentException("Bad name for student");
        if (age < 0) throw new IllegalArgumentException("Bad age for student");
    }

    // overriding for accessors
    @Override
    public String name() {
        System.out.println("Someone got name value!");
        return name;
    }

    // non-canonical constructor
    public Student(){
        this("anon", 0);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    class Inner {

    }

    static class Static {

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


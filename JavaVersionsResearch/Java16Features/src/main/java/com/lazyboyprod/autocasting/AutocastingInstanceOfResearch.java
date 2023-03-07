package com.lazyboyprod.autocasting;

import lombok.*;

public class AutocastingInstanceOfResearch {

    public static void inverseChecksApproach(String[] args) {
        var person = getPerson();

        // new style
        if (!(person instanceof Employee em)) {
            // cannot use variable em here because it's not an employee!
            System.out.println("This is an employee with age " + person);
        } else if (person instanceof Student st) {
            System.out.println("This is a student with email " + st.email);
        } else {
            System.out.println("You can use variable 'em' here " + em.age);
        }
    }

    public static void straightforwardApproach(String[] args) {
        var person = getPerson();

        // old style
        if (person instanceof Employee) {
            System.out.println("This is an employee with age " + ((Employee) person).age);
        } else if (person instanceof Student) {
            System.out.println("This is a student with email " + ((Student) person).email);
        }

        // new style
        if (person instanceof Employee em) {
            System.out.println("This is an employee with age " + em.age);
        } else if (person instanceof Student st) {
            System.out.println("This is a student with email " + st.email);
        }
    }

    private static Person getPerson() {
        return Math.random() > 0.5 ? new Employee("Bobby", 40) : new Student("Jack", "jb@kg");
    }

}

@Getter
@Setter
@ToString
@AllArgsConstructor
class Person {
    protected String name;
}

@Getter
@Setter
@ToString
class Employee extends Person {
    protected int age;

    public Employee(String name, int age) {
        super(name);
        this.age = age;
    }
}

@Getter
@Setter
@ToString
class Student extends Person {
    protected String email;

    public Student(String name, String email) {
        super(name);
        this.email = email;
    }
}

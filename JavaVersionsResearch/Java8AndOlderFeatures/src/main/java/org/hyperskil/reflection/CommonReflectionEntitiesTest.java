package org.hyperskil.reflection;

import org.hyperskil.reflection.test.Person;
import org.hyperskil.reflection.test.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CommonReflectionEntitiesTest {

    public static void main(String[] args) {
        System.out.println(ComplexClass.class.getDeclaredFields().length);
    }

    public static class SimpleClass {
        public String b;
    }

    public static class ComplexClass extends SimpleClass {
        private String a;
    }



    public static void mainStudentClassInfo(String[] args) {
        Person person = new Student();
        getInfo(person.getClass());
    }

    public static void getPersonClassInfo(String[] args) {
        Person person = new Person();
        Class<? extends Person> cl = person.getClass();
        getInfo(cl);
    }

    public static void getInfo(Class clazz) {
        Constructor[] constructors = clazz.getConstructors();
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();

        Method[] methods = clazz.getMethods();
        Method[] declaredMethods = clazz.getDeclaredMethods();

        Field[] fields = clazz.getFields();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Constructor constructor : constructors) {
            System.out.println("Constructor: " + constructor.getName());
        }

        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("Declared constructor: " + declaredConstructor.getName());
        }

        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
        }

        for (Method declaredMethod : declaredMethods) {
            System.out.println("Declared method: " + declaredMethod.getName());
        }

        for (Field field : fields) {
            System.out.println("Field: " + field.getName());
        }

        for (Field declaredField : declaredFields) {
            System.out.println("Declared field: " + declaredField.getName());
        }

    }
}

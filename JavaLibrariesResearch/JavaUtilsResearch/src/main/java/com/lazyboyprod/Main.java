package com.lazyboyprod;

import org.openjdk.jol.info.ClassLayout;

import java.io.IOException;

public class Main {

    /*
        byte = 1 byte = 8 bit
        short = 2 byte = 16 bit
        int = 4 byte = 32 bit
        long = 8 byte = 64 bit

        char = 2 byte = 16 bit
    */

    /*
        java object =
            header (32x - 8b, 64x - 16b) =
                mark word
              +
                hash code
              +
                gc info = some bits
              +
                type info block pointer
              +
                lock
              +
                array length - if object - array -> header size + 4 bytes for array length
          +
            memory for primitive types
          +
            memory for reference type
          +
            offset - несколько байт для картности машинному слову. в Java размер любого объекта кратен 8
     */

    /*
        как считать значения для объектов:
        1. ищем все поля не объявленные как static
        2. заголовок 8 байт
        3. сумма по примитивным полям
        4. если ссылочные переменные то + 4 байта


     */




    public static void main(String[] args) throws IOException {
        //System.out.println(ClassLayout.parseInstance(new MyObject()).toPrintable());

        //System.out.println(ClassLayout.parseInstance(new OtherObject()).toPrintable());

        System.out.println(ClassLayout.parseInstance("ab").toPrintable());
        System.out.println(ClassLayout.parseInstance("abcd").toPrintable());
        System.out.println(ClassLayout.parseInstance("abcdabcd").toPrintable());
        System.out.println(ClassLayout.parseInstance("abcdabcdabcdabcd").toPrintable());
        System.out.println(ClassLayout.parseInstance("abcdabcdabcdabcdabcdabcdabcdabcd").toPrintable());


        System.out.println(MemoryUtils.sizeOf("ab", null, null));
        System.out.println(MemoryUtils.sizeOf("abcd", null, null));
        System.out.println(MemoryUtils.sizeOf("abcdabcd", null, null));
        System.out.println(MemoryUtils.sizeOf("abcdabcdabcdabcd", null, null));
        System.out.println(MemoryUtils.sizeOf("abcdabcdabcdabcdabcdabcdabcdabcd", null, null));

        //        String s1 = "abc";
//        System.out.println(ClassLayout.parseInstance(s1).toPrintable());
//        System.out.println();
//        System.out.println(ClassLayout.parseInstance(new byte[]{1,2,3,4,5,6,7,8}).toPrintable());

        //System.out.println(MemoryUtils.sizeOf(s1, null, null));

    }

    private static void getSize(Object obj) throws IOException {
        System.out.println("Object: " + obj + " with type " + obj.getClass() + " occupied memory " + AllocatedMemoryMeasurer.getMemoryLength(obj));
    }

    static class MyObject {

        private int a = 1;
        private int b = 2;
        private int c = 3;
        private int d = 4;

        private OtherObject obj = new OtherObject();

    }

    // 16 bytes
    static class OtherObject {
        private int Long = 5;
    }
}
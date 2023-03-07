package com.lazyboyprod;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;

public class MemoryUtils {

    private static Map<Class, Integer> primitiveSizes = new HashMap<>();

    static {
        primitiveSizes.put(byte.class, 1);
        primitiveSizes.put(short.class, 2);
        primitiveSizes.put(int.class, 4);
        primitiveSizes.put(long.class, 8);
        primitiveSizes.put(float.class, 4);
        primitiveSizes.put(double.class, 8);
        primitiveSizes.put(char.class, 2);
        primitiveSizes.put(boolean.class, 1);
    }

    private static Set<Class> boxed = new HashSet<>();

    static {
        boxed.add(Byte.class);
        boxed.add(Short.class);
        boxed.add(Integer.class);
        boxed.add(Long.class);
        boxed.add(Float.class);
        boxed.add(Double.class);
        boxed.add(Character.class);
        boxed.add(Boolean.class);
    }

    static final int REFERENCE_SIZE = 4;

    static long calls = 0;

    public static long sizeOf(Object object, List<Object> calculated, Class clazz) {
        try {
            calls++;
            if (calls % 1000 == 0) {
                System.out.println("MemoryUtils call # " + calls);
            }
            if (calculated == null) {
                calculated = new ArrayList<>();
            }
            if (object == null) {
                return 0;
            }

            long result = 0;
            if (clazz == null) {
                clazz = object.getClass();
            }
//            if(clazz == String.class) {
//                return ((String)object).length() * 2 + 38;
//            }
            if (object.getClass() == Object.class) {
                return REFERENCE_SIZE * 2;
            }
            if (clazz.isPrimitive()) {
                int size = primitiveSizes.get(clazz);
                result += size;
            } else if (clazz.isArray()) {
                int length = Array.getLength(object);
                for (int i = 0; i < length; i++) {
                    Object element = Array.get(object, i);
                    if (!calculated.contains(element) && element != null) {
                        Class typeToPass = element.getClass();
                        if (boxed.contains(typeToPass)) {
                            typeToPass = object.getClass().getComponentType();
                        }

                        result += sizeOf(element, calculated, typeToPass);
                    }
                }
            } else {
                result += REFERENCE_SIZE;
                calculated.add(object);
                for (Field f : clazz.getDeclaredFields()) {
                    if (java.lang.reflect.Modifier.isStatic(f.getModifiers())) {
                        continue;
                    }
                    f.setAccessible(true);
                    try {
                        Object value = f.get(object);
                        if (!calculated.contains(value) && value != null) {
                            Class typeToPass = value.getClass();
                            if (boxed.contains(typeToPass)) {
                                typeToPass = f.getType();
                            }
                            result += sizeOf(value, calculated, typeToPass);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("MemoryUtils class = " + clazz.getName() + " value = " + object + " size = " + result + " isPrimitive = " + clazz.isPrimitive());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
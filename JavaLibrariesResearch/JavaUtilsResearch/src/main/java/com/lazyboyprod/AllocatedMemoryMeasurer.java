package com.lazyboyprod;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class AllocatedMemoryMeasurer {

    public static int getMemoryLength(Object object) throws java.io.IOException {
        ByteArrayOutputStream byteObject = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteObject);
        objectOutputStream.writeObject(object);
        objectOutputStream.flush();
        objectOutputStream.close();
        byteObject.close();

        return byteObject.toByteArray().length;
    }

}

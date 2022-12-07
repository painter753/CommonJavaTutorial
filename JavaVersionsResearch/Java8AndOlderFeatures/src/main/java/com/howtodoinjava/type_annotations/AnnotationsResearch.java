package com.howtodoinjava.type_annotations;

import lombok.NonNull;

import java.lang.annotation.Repeatable;

public class AnnotationsResearch {

    public static void typeAnnotationsResearch(String[] args) {
        // will get warning from compiler
        @NonNull String value = null;
        System.out.println(value);
    }

    public static void repeatableAnnotationsResearch(String[] args) {

        @Notify(email = "bobbybrown@fz.com")
        @Notify(email = "bobbybrown@fz.com")
        class NotAllowedException extends Exception {

        }

    }


}

@Repeatable(Notifications.class)
@interface Notify {
    String email();
}

// container for repeatable annotations
@interface Notifications {
    Notify[] value();
}

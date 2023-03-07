package com.lazyboyprod.howtodoinjava.diamonds;

public class DiamondsForAnonResearch {

    StringAppender<String> appender = new StringAppender<String>() {
        @Override
        public String append(String a, String b) {
            return new StringBuilder(a).append("-").append(b).toString();
        }
    };

    public abstract static class StringAppender<T> {
        public abstract T append(String a, String b);
    }
}

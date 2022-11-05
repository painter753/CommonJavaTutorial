package ru.smirnov.enums;

public class EnumsResearch {

    public static void main(String[] args) {
        System.out.println(StringToBooleanValues.valueOf("Y").getBoolean());
    }

    public static enum StringToBooleanValues {
        Y, N;

        public boolean getBoolean() {
            switch (this) {
                case Y:return true;
                case N:return false;
                default:return false;
            }
        }


    }

}

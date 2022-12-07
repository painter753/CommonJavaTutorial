package com.lazyboyprod.switch_improvements;

import java.time.Month;

public class SwitchImprovementsResearch {

    private static void switchWithoutBreaksImprovement() {
        int days = 0;
        Month month = Month.APRIL;

        // old style
        switch (month) {
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER :
                days = 31;
                break;
            case FEBRUARY :
                days = 28;
                break;
            case APRIL, JUNE, SEPTEMBER, NOVEMBER :
                days = 30;
                break;
            default:
                throw new IllegalStateException();
        }

        month = Month.JANUARY;
        // new style
        days = switch (month) {
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> 31;
            case FEBRUARY -> 28;
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30;
            default -> throw new IllegalStateException();
        };
        System.out.println(days + " days in " + month);
    }
    private static void yieldInSwitch() {
        int days = 0;
        Month month = Month.APRIL;

        days = switch (month) {
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> {
                System.out.println("Place for additional operations");
                yield 31;
            }
            case FEBRUARY -> 28;
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30;
            default -> throw new IllegalStateException();
        };
        System.out.println(days + " days in " + month);
    }

    public static void main(String[] args) {
        switchWithoutBreaksImprovement();
        yieldInSwitch();
    }



}

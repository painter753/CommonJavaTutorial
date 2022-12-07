package com.lazyboyprod.module2;

import com.lazyboyprod.printer.filter.CustomStringFilter;
import com.lazyboyprod.printer.CustomPrinter;
import com.lazyboyprod.printer.SimpleCustomPrinter;

public class AppModule2 {
    public static void main( String[] args ) {
        CustomPrinter printer = new SimpleCustomPrinter();
        printer.print("Hello 123wrld");

        printer = new SimpleCustomPrinter(new CustomStringFilter() {
            @Override
            public String filter(String s) {
                return null;
            }
        });
    }
}

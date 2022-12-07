package com.lazyboyprod;

import com.lazyboyprod.printer.CustomPrinter;
import com.lazyboyprod.printer.SimpleCustomPrinter;

public class AppModule1 {
    public static void main( String[] args ) {
        CustomPrinter printer = new SimpleCustomPrinter();
        printer.print("asdasdasd");
        printer.print("123123asdasd");
    }
}

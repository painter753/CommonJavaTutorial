package com.lazyboyprod.printer;

import com.lazyboyprod.printer.filter.CustomStringFilter;
import com.lazyboyprod.printer.filter.NoDigitsStringFilter;

final public class SimpleCustomPrinter implements CustomPrinter {

    private CustomStringFilter filter;

    public SimpleCustomPrinter() {
        filter = new NoDigitsStringFilter();
    }

    public SimpleCustomPrinter(CustomStringFilter filter) {
        this.filter = filter;
    }

    public void print(String s) {
        System.out.println(filter.filter(s));
    }
}

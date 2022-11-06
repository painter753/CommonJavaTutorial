package com.lazyboyprod.printer.filter;

public class NoDigitsStringFilter implements CustomStringFilter {

    public String filter(String s) {
        return s.replaceAll("[0-9]", "");
    }
}

package com.lazyboyprod;

public class TextBlockFormattingResearch {

    public static void main(String[] args) {
        // old format
        System.out.println(
                "there is \n" +
                        "some very big and \n" +
                        "uncomfortable for reading variable value\n" +
                        "Too much \n" +
                        "rows and\n cumbersome \n" +
                        "formatting"
        );

        // new format
        // !! after opening triple quotes we need new line, otherwise we'll get an error "Illegal text block start: missing new line after opening quotes."
        System.out.println(
                """
                   That is another
                        approach to 
                        
                        write well formatted text without using concatenations
                        """
        );
    }
}

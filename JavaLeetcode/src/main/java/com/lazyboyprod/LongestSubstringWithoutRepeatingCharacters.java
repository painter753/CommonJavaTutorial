package com.lazyboyprod;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestSubstringWithoutRepeatingCharacters {
//TODO
    public static void main(String[] args) {
        lengthOfLongestSubstring("aaaa");
    }

        public static int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> chars = new HashMap<>();
            int pointer1 = 0;
            int pointer2 = 0;

            String maxString = "";

            for(int i = 0; i < s.length(); i++) {
                pointer2 = i;
                Character c = s.charAt(i);
                Integer charPosition = chars.get(c);

                if (charPosition == null) {
                    if (i == s.length() - 1) {
                        maxString = compareAndReturnLongest(maxString, s.substring(pointer1, pointer2 + 1));
                        break;
                    }
                    chars.put(c, i);
                } else {
                    maxString = compareAndReturnLongest(maxString, s.substring(pointer1, pointer2));

                    pointer1 = charPosition + 1;
                    chars = chars.entrySet()
                            .stream().filter(it -> it.getValue() >= charPosition)
                            .collect(
                                    Collectors.toMap(
                                            it -> it.getKey(), it -> it.getValue()
                                    ));
                    chars.put(c, pointer2);
                }
            }


            System.out.println("Longest substring: " + maxString);
            return maxString.length();
        }

        private static String compareAndReturnLongest(String str1, String str2) {
            return (str1.length() >= str2.length()) ? str1 : str2;
        }
}

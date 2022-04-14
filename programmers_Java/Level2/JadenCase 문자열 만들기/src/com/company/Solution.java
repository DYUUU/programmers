package com.company;

import java.util.Locale;

public class Solution {
    public String solution(String s) {
        s = s.toLowerCase(Locale.ROOT);
        StringBuilder str = new StringBuilder(s);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                if (i == 0) {
                    str.setCharAt(i, (char) (str.charAt(i) - 32));
                } else if (i > 0) {
                    if (str.charAt(i - 1) == ' ') {
                        str.setCharAt(i, (char) (str.charAt(i) - 32));
                    }
                }
            }
        }

        return str.toString();
    }
}

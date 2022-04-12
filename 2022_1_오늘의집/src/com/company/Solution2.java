package com.company;

import java.util.Arrays;
import java.util.Locale;

public class Solution2 {
    public String solution(String call) {
        int[] alphabet = new int[26];
        int max = 0;

        for (int i = 0; i < call.length(); i++) {
            int alphabetNum = call.charAt(i) - 'a';
            if(call.charAt(i)>='A'&&call.charAt(i)<='Z')
            {
                alphabetNum+=32;
            }
                alphabet[alphabetNum] += 1;

            // find max value
            if (max < alphabet[alphabetNum])
                max = alphabet[alphabetNum];
        }

        for (int i = 0; i < alphabet.length; i++) {
            char lower = (char) (i + 'a');
            char upper = (char) (i + 'a'-32);
            if (alphabet[i] == max) {
                // remove lower
                call = call.replaceAll(String.valueOf(lower), "");
                // remove upper
                call = call.replaceAll(String.valueOf(upper), "");
            }
        }

        System.out.println(call);


        return call;
    }
}
